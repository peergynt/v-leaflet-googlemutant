package org.vaadin.addon.leaflet.googlemutant.client;

import com.vaadin.shared.ui.Connect;
import org.peimari.gleaflet.client.GridLayer;
import org.peimari.gleaflet.client.GridLayerOptions;
import org.peimari.gleaflet.client.googlemutant.GoogleMutant;
import org.peimari.gleaflet.client.googlemutant.GoogleMutantOptions;
import org.vaadin.addon.leaflet.client.LeafletGridLayerConnector;
import org.vaadin.addon.leaflet.googlemutant.LGoogleMutant;

@Connect(LGoogleMutant.class)
public class LeafletGoogleMutantConnector extends LeafletGridLayerConnector {

    @Override
    public LeafletGoogleMutantState getState() {
        return (LeafletGoogleMutantState) super.getState();
    }

    protected GoogleMutantOptions createOptions() {
        GoogleMutantOptions o = super.createOptions().cast();
        LeafletGoogleMutantState s = getState();

        if (s.type != null) {
            o.setType(s.type);
        }
        if (s.errorTileUrl != null) {
            o.setErrorTileUrl(s.errorTileUrl);
        }
        if (s.continuousWorld != null) {
            o.setContinuousWorld(s.continuousWorld);
        }
        return o;
    }

    @Override
    protected GridLayer createGridLayer(GridLayerOptions o) {
        return GoogleMutant.create((GoogleMutantOptions) o);
    }
}
