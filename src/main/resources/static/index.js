let map;
let marker = new Map();
let squareCoords = [];
let wzSquare;
const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/infrarob-data'
});

stompClient.onConnect = (frame) => {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/positioning-data', (vehicle_data) => {
        showPosiotionData(JSON.parse(vehicle_data.body));
    });
    stompClient.subscribe('/topic/polygon-created', (vehicle_data) => {
        showPolygon();
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

function sendPolygonCoordinates() {
    stompClient.publish({
        destination: "/app/poylgon-coordinates",
        body: JSON.stringify(squareCoords)
    });
}

function showPosiotionData(positions) {
    console.log(positions.positionList.length);
    let i = 0;
    while ( i < positions.positionList.length){
        var pos = positions.positionList[i];
        console.log(pos);
        moveMarker(pos["vehicleID"], parseFloat(pos["lat"]), parseFloat(pos["lon"]));
        i++;
    }
    //console.log(message["vehicleID"]);

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
    squareCoords.push(mapsMouseEvent.latLng.toJSON());
    sendPolygonCoordinates();
}

async function showPolygon(){
    if(squareCoords.length == 4){
        wzSquare = new google.maps.Polygon({
            paths: squareCoords,
            strokeColor: "#FF0000",
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: "#FF0000",
            fillOpacity: 0.35,
        });
        wzSquare.setMap(map);
    }else if(squareCoords.length >4){
        //wzSquare = new google.maps.Polygon({});
        squareCoords = [];
        wzSquare.setMap(null);
    }
}

async function moveMarker(id, lat, lon){

    console.log(marker)
    console.log("move marker");
    if(!marker.has(id)){
        console.log("not exists -> creating");
        const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");
        marker.set(id,new AdvancedMarkerElement(
            {
                map,
                position: { lat: lat, lng: lon },
            }
        ));


    }else{
        console.log("moving");
        marker.get(id).position = (new google.maps.LatLng(lat,lon));
    }
}




initMap();
connect();
setInterval(pullData, 1000);


