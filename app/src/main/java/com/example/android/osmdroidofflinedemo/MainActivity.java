package com.example.android.osmdroidofflinedemo;

import android.app.Activity;
import android.os.Bundle;

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends Activity {

    public static final GeoPoint BERLIN = new GeoPoint(31.2365071255,121.4665718296);
    public static final OnlineTileSourceBase LOCAL_OSM_FILES = new XYTileSource("4uMaps",
            ResourceProxy.string.mapquest_osm, 0, 15, 256, ".png", new String[] { });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setClickable(true);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.setUseDataConnection(true);
        //mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setTileSource(LOCAL_OSM_FILES);
        IMapController mapViewController = mapView.getController();
        mapViewController.setZoom(6);
        mapViewController.setCenter(BERLIN);
    }

}
