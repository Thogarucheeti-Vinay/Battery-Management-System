function getBatteryInfoById() {
    const batteryId = document.getElementById("batteryId").value;
    fetch(`/api/getBatteryInfoByID/${batteryId}`)
        .then(response =>
            response.json())
        .then(data => {
            console.log(data)
            if(data.statusCode === 200) {
                const responseArray = data.response;
                document.getElementById("batteryInfo").innerHTML = "";

                for (let i = 0; i < responseArray.length; i++) {
                    const batteryData = responseArray[i];
                    const battery_id = document.createElement("p");
                    battery_id.className = "current";
                    battery_id.innerText = "Batter ID : " + batteryData.battery_id;
                    document.getElementById("batteryInfo").appendChild(battery_id);

                    const current = document.createElement("p");
                    current.className = "current";
                    current.innerText = "Current : " + batteryData.current;
                    document.getElementById("batteryInfo").appendChild(current);

                    const voltage = document.createElement("p");
                    voltage.className = "voltage";
                    voltage.innerText = "Voltage : " + batteryData.voltage;
                    document.getElementById("batteryInfo").appendChild(voltage);

                    const temperature = document.createElement("p");
                    temperature.className = "temperature";
                    temperature.innerText = "Tempertaure : " + batteryData.temperature;
                    document.getElementById("batteryInfo").appendChild(temperature);

                    const time = document.createElement("p");
                    time.className = "time";
                    time.innerText = "Time : " + new Date(batteryData.time).toLocaleString();
                    document.getElementById("batteryInfo").appendChild(time);

                }
            }
        });
}

function getSpecificBatteryAttribute() {
    const batteryId = document.getElementById("batteryId2").value;
    const attribute = document.getElementById("attributeDropdown1").value;
    fetch(`/api/getSpecificBatteryAttributeByID/${batteryId}/${attribute}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            if(data.statusCode === 200) {
                const responseArray = data.response;
                document.getElementById("attributeInfo").innerHTML = "";
                document.getElementById("attributeInfo").innerText = JSON.stringify(responseArray);
            }
        });
}

function getSpecificBatteryAttributeByTime() {
    const batteryId = document.getElementById("batteryId3").value;
    const attribute = document.getElementById("attributeDropdown2").value;
    let startTime = document.getElementById("startTime").value;
    startTime = new Date(startTime).getTime();
    let endTime = document.getElementById("endTime").value;
    endTime = new Date(endTime).getTime();

    fetch(`/api/getSpecificBatteryAttributeByID/${batteryId}/${attribute}/${startTime}/${endTime}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            if(data.statusCode === 200) {
                const responseArray = data.response;
                document.getElementById("attributeTimeInfo").innerHTML = "";
                document.getElementById("attributeTimeInfo").innerText = JSON.stringify(responseArray);
            }
        });
}
