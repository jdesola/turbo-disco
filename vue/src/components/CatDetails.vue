<template>
  <div class="catDetailsContainer flex">
    <h1 class="catRankings">Cat Rankings Placeholder2</h1>
    <vue-mapbox-map
      id="map-container"
      :access-token="map.accessToken"
      :interactive="false"
      :lng="map.lng"
      :lat="map.lat"
      :zoom="map.zoom"
      :pitch="map.pitch"
      :bearing="map.bearing"
      mapStyle="mapbox://styles/livtolle/ckimct6b505dc18k62mdbx7i8"
      @mapbox-ready="setMap"
      @mapbox-destroyed="unsetMap"
    ></vue-mapbox-map>
  </div>
</template>

<script>
import VueMapboxMap from "vue-mapbox-map";

export default {
  name: "catDetails",
  props: ["cat"], // mapbox requires an access token
  // access as "access-token"
  accessToken: {
    type: String,
    required: false,
    default:
      "pk.eyJ1IjoibGl2dG9sbGUiLCJhIjoiY2tpbWF3NDA5MDdnMzJ0cGdpeGE0NWc2YyJ9.Iki6ohLmSdN_GzZTKtmvHg",
  },
  // target map style, you can also load a local map style configuration
  // access as "map-style"
  mapStyle: {
    type: [String, Object],
    default: "mapbox://styles/livtolle/ckimct6b505dc18k62mdbx7i8",
  },
  // whether to display the attribution control
  // this is required by mapbox unless you fulfill this requirement elsehow
  // access as "attribution-control"
  attributionControl: {
    type: Boolean,
    default: true,
  },
  // whether map can be interacted with
  interactive: {
    type: Boolean,
    default: true,
  },
  // whether to jump, ease, or fly for transitions
  transitionMode: {
    type: String,
    required: false,
    default: "jump",
    validator: function (value) {
      return ["jump", "ease", "fly"].indexOf(value) !== -1;
    },
  },
  // longitude (dynamic)
  lng: {
    type: [Number, String],
    required: true,
  },
  // latitude (dynamic)
  lat: {
    type: [Number, String],
    required: true,
  },
  // zoom (dynamic)
  zoom: {
    type: [Number, String],
    default: 13,
  },
  // pitch (dynamic)
  pitch: {
    type: [Number, String],
    default: 60,
  },
  // bearing (dynamic)
  bearing: {
    type: [Number, String],
    default: 0,
  },
  components: {
    VueMapboxMap,
  },
  data() {
    return {
      map: {
        accessToken:
          "pk.eyJ1IjoibGl2dG9sbGUiLCJhIjoiY2tpbWF3NDA5MDdnMzJ0cGdpeGE0NWc2YyJ9.Iki6ohLmSdN_GzZTKtmvHg",
        lng: -73.984495,
        lat: 40.756027,
        zoom: 13,
        pitch: 20,
        bearing: 0,
      },
    };
  },

  //   created() {
  //       mapboxgl.accessToken = this.accessToken;

  //         new mapboxgl.Map({
  //           container: "#map",
  //           style:  "mapbox://styles/livtolle/ckimct6b505dc18k62mdbx7i8",
  //           center: [103.811279, 1.345399],
  //           zoom: 12,
  //           maxBounds: [
  //               [103.6, 1.1704753],
  //               [104.1, 1.4754753]
  //           ]
  //       });
};
</script>

<style >
#map-container {
  position: absolute;
  height: 100%;
  width: 100%;
}

.catDetailsContainer {
    width: 100%;
}

</style>
