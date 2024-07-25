let map;
let marker = new Map();

let wzSquare;
let infoWindow;
const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/infrarob-data',
});

stompClient.onConnect = (frame) => {

    console.log('Connected: ' + frame);

    getPolygonCoordinates();

    stompClient.subscribe('/topic/positioning-data', (vehicle_data) => {
        //console.log(vehicle_data.body);
        showPosiotionData(JSON.parse(vehicle_data.body));
    });
    stompClient.subscribe('/topic/polygon-created', (polygon_coordinates) => {
        showPolygon(JSON.parse(polygon_coordinates.body));
    });
    stompClient.subscribe('/topic/safe-zone-infraction', (vehicle_data) => {
        let data = JSON.parse(vehicle_data.body);
        let objectdata = data.objectDataWS

        const myLatlng = {lat: parseFloat(objectdata.lat), lng: parseFloat(objectdata.lon)};

        infoWindow = new google.maps.InfoWindow({
            position: myLatlng,
        });

        infoWindow.setContent(
            JSON.stringify(data.message + " " + objectdata.lat + ", " + objectdata.lon, null, 2),
        );
        infoWindow.open(map);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};


function connect() {
    stompClient.activate();
    console.log("connecting")
}

function disconnect() {
    stompClient.deactivate();
    console.log("Disconnected");
}

function pullData() {
    stompClient.publish({
        destination: "/app/vehicledata",
        body: ""
    });
}

function sendPolygonCoordinates(coordinates) {
    stompClient.publish({
        destination: "/app/poylgon-coordinates",
        body: JSON.stringify(coordinates)
    });
}

function getPolygonCoordinates() {
    console.log("get polygon data")
    stompClient.publish({
        destination: "/app/poylgon-coordinates-get",
        body: "",
    });
}

function showPosiotionData(positions) {
    let i = 0;
    while ( i < positions.length){
        var pos = positions[i];
        //console.log(pos);
        moveMarker(pos["objectID"], parseFloat(pos["lat"]), parseFloat(pos["lon"]));
        i++;
    }
    //console.log(message["objectID"]);

}


async function initMap() {
    const { Map } = await google.maps.importLibrary("maps");

    map = new Map(document.getElementById("map"), {
        center: { lat: 41.487673, lng: -8.342111 },
        zoom: 20,
        mapId: "4504f8b37365c3d0",
    });


    map.addListener("click", (mapsMouseEvent) => clickLatLon(mapsMouseEvent));
}

function clickLatLon(mapsMouseEvent){
    sendPolygonCoordinates(mapsMouseEvent.latLng.toJSON());
}

async function showPolygon(squareCoords){
    //console.log(squareCoords)
    if(squareCoords.length < 1){
        return;
    }

    if(wzSquare != null) {
        wzSquare.setMap(null);
    }
    //squareCoords.push(mapsMouseEvent.latLng.toJSON());

    wzSquare = new google.maps.Polygon({
        paths: squareCoords,
        strokeColor: "#FF0000",
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: "#FF0000",
        fillOpacity: 0.35,
    });
    wzSquare.setMap(map);

}

async function moveMarker(id, lat, lon){

    //console.log(marker)
    //console.log("move marker");
    if(!marker.has(id)){
        //console.log("not exists -> creating");
        const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");
        marker.set(id,new AdvancedMarkerElement(
            {
                map,
                position: { lat: lat, lng: lon },
            }
        ));


    }else{
        marker.get(id).position = (new google.maps.LatLng(lat,lon));
    }
}

initMap();
connect();

setInterval(pullData, 1000);
