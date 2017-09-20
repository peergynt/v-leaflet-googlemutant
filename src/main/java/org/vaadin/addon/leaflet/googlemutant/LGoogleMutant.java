package org.vaadin.addon.leaflet.googlemutant;

import org.vaadin.addon.leaflet.LGridLayer;
import org.vaadin.addon.leaflet.googlemutant.client.LeafletGoogleMutantState;

public class LGoogleMutant extends LGridLayer {

    public enum Type {
        ROADMAP, SATELLITE, TERRAIN, HYBRID
    }

    private Type type = Type.ROADMAP;

    public LGoogleMutant() {}

    public LGoogleMutant(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getErrorTileUrl() {
        return getState().errorTileUrl;
    }

    public void setErrorTileUrl(String errorTileUrl) {
        getState().errorTileUrl = errorTileUrl;
    }

    public Boolean getContinuousWorld() {
        return getState().continuousWorld;
    }

    public void setContinuousWorld(Boolean continuousWorld) {
        getState().continuousWorld = continuousWorld;
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        getState().type = type.toString().toLowerCase();
        super.beforeClientResponse(initial);
    }

    @Override
    protected LeafletGoogleMutantState getState() {
        return (LeafletGoogleMutantState) super.getState();
    }
}
