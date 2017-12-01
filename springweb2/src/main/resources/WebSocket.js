var sock = new WebSocket('ws://' + window.location.host + '/mySocketHandler');
sock.onmessage = function(e) {
    console.log('Received message: ', e.data);
};
sock.send("Hello ");