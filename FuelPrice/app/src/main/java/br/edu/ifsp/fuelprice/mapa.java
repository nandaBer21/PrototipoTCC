package br.edu.ifsp.fuelprice;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng localizacaoAtual;
    private Marker marcadorAtual;

    private Marker marcadorSearch;

    public static final int MY_LOCATION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_local_postos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Pedir permissão pro usuário
        requestPermission();

        monitoringUser();
    }

    private void requestPermission() {

        boolean needPermission = false;

        String[] permissions = new String[2];

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            permissions[0] = Manifest.permission.ACCESS_FINE_LOCATION;
            needPermission = true;

        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            permissions[1] = Manifest.permission.ACCESS_COARSE_LOCATION;
            needPermission = true;
        }

        if(needPermission){
            requestPermissions(permissions, MY_LOCATION_REQUEST_CODE);

        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);

        LatLng center_world = new LatLng(0, 0);
        LatLng ifsp_ctd = new LatLng(-21.1465037, -48.9466838);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(center_world));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ifsp_ctd, 15.0f));

        MarkerOptions mo = new MarkerOptions();
        mo.position(ifsp_ctd);
        mo.title("IFSP");
        mo.snippet("Catanduva");
        //mo.icon(BitmapDescriptorFactory.defaultMarker(
        //                BitmapDescriptorFactory.HUE_ORANGE));


        mo.icon(bitmapDescriptorFactoryFromVector(this, R.mipmap.ic_launcher_foreground_logo));

        Marker marcador = mMap.addMarker(mo);
        marcador.showInfoWindow();
        //marcador.remove();//desaparece com o balão


        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }

    private BitmapDescriptor bitmapDescriptorFactoryFromVector(Context context,
                                                               int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());

        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);

    }

    @Override
    public void onLocationChanged(Location location) {
        if (marcadorAtual != null){
            marcadorAtual.remove();
        }

        localizacaoAtual = new LatLng(location.getLatitude(), location.getLongitude());

        //Criar o balão
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(localizacaoAtual);
        DateFormat dateFormat = new SimpleDateFormat("YYYY/MMdd HH:mm:ss");
        markerOptions.title("Aqui! @ " + dateFormat.format(new Date()));
        markerOptions.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        //Add marker (retorna o marcador)
        marcadorAtual = mMap.addMarker(markerOptions);

        //camara acompanhar o usuário
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(localizacaoAtual, 15.0f));

    }


    private void monitoringUser(){
        if(hasPermission()){ //Tem Permissão
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            boolean hasNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            boolean hasGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

            try {

                if (!hasGPS) { //Tem GPS
                    //pedir para ligar o GPS
                    requestGPS();

                }

                else {
                    lm.requestLocationUpdates( //Fica atualizando
                            LocationManager.GPS_PROVIDER, //provedor de Localização);
                            10000, /*Tempo de atualização em milisegundos*/
                            10, /*Distância em metros*/
                            this);
                }

                if(!hasGPS && hasNetwork){ //Se não tem GPS, mas tem Rede
                    Toast.makeText(this, "Buscando localização pela Rede!", Toast.LENGTH_LONG).show();


                    lm.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER, //provedor de Localização);
                            10000, /*Tempo de atualização em milisegundos*/
                            10, /*Distância em metros*/
                            this);
                }


            }catch (SecurityException ex){
                Toast.makeText(this, "Error: " + ex.getMessage(),
                        Toast.LENGTH_LONG).show();
            }

        }
    }

    private boolean hasPermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            return (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED) ||

                    (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED);

        }

        return true;

    }

    private void requestGPS(){

        new AlertDialog.Builder(this)
                .setTitle("Sua localização pode ser obtida pelo GPS!")
                .setMessage("Ativar o GPS?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() { //clica 2 vezes sobre DialogInterface, que ele preenche
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent (Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
    }

    public void searchAddress (View v){
        EditText edtSearch = findViewById(R.id.edtSearch);
        String address = edtSearch.getText().toString();

        if(!TextUtils.isEmpty(address)){
            //faço a busca

            if(marcadorSearch != null)
                marcadorSearch.remove();

            Geocoder geocoder = new Geocoder(this);

            if(Geocoder.isPresent()){
                try{
                    List<Address> listAddress;
                    listAddress = geocoder.getFromLocationName(address, 3);

                    if(listAddress != null) {

                        if (listAddress.size() > 0) {

                            for (Address as : listAddress) {

                                LatLng location = new LatLng(as.getLatitude(), as.getLongitude());

                                marcadorSearch = mMap.addMarker(new MarkerOptions()
                                        .position(location)
                                        .title("Location: " + address)
                                        .icon(BitmapDescriptorFactory
                                                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

                                );

                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 12.0f));
                            }
                        }
                        else{
                            Toast.makeText(this, "Nenhum endereço para: " +
                                    address, Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(this, "Nenhum endereço para: " +
                                address, Toast.LENGTH_LONG).show();
                    }
                }
                catch (IOException ex){
                    Toast.makeText(this, ex.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this, "Serviço de busca indisponível",
                        Toast.LENGTH_LONG);
            }
        }
        else{
            Toast.makeText(this, "Por favor, digite o endereço",
                    Toast.LENGTH_LONG).show();
        }
    }
}
