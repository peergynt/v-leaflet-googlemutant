# Leaflet.GridLayer.GoogleMutant plugin wrapper for Vaadin 

This module provides server side APi for the [Leaflet.GridLayer.GoogleMutant](https://gitlab.com/IvanSanchez/Leaflet.GridLayer.GoogleMutant) plugin.

See [Demo](http://ivansanchez.gitlab.io/Leaflet.GridLayer.GoogleMutant/demo.html).

This module depends on the client(GWT) [g-leaflet-googlemutant](https://github.com/octavm/g-leaflet-googlemutant) library and on [v-leaflet](https://github.com/mstahv/v-leaflet) Vaadin add-on.

Release downloads:
[Vaadin Directory](https://vaadin.com/directory/)

### Usage
To use it, you'll need to provide Google Maps JS api to your host page. In it you also must pass in your Google Maps API key. Thus, it is not injected automatically, but you should provide it with e.g. BootstrapListener like this:

```java
@Override
protected void servletInitialized() throws ServletException {
    getService().addSessionInitListener(new SessionInitListener() {
        @Override
        public void sessionInit(SessionInitEvent event)
                throws ServiceException {
            event.getSession().addBootstrapListener(new BootstrapListener() {

                @Override
                public void modifyBootstrapFragment(BootstrapFragmentResponse response) {
                }

                @Override
                public void modifyBootstrapPage(BootstrapPageResponse response) {
                    Element script = response.getDocument().createElement("script");
                    // FOR NON LOCAL TESTING, ADD API KEY!!
                    // script.attr("src", "http://maps.google.com/maps/api/js?key=YOUR-API-KEY-HERE&sensor=false");
                    script.attr("src", "http://maps.google.com/maps/api/js?sensor=false");
                    response.getDocument().getElementsByTag("head").get(0).appendChild(script);
                }
            });

```

First, create an instance of LGoogleMutant passing the type of base map as a parameter. If empty constructor is used, then type ROADMAP is the default:
```java
final LGoogleMutant satellite = new LGoogleMutant(LGoogleMutant.Type.SATELLITE);
final LGoogleMutant terrain = new LGoogleMutant(LGoogleMutant.Type.TERRAIN);
```
```java
Then, you can add the created base maps to the leaflet map:
leafletMap.addBaseLayer(satellite, "Google Satellite");
leafletMap.addBaseLayer(terrain, "Google Terrain");
```


The implementation depends on g-leaflet-googlemutant project. During development you'll most likely want to check out that as well. When using the add-on, dependency should be automatically resolved.

https://github.com/mstahv/g-leaflet-googlemutant

