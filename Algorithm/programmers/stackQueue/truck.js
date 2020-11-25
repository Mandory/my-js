function solution(bridge_length, weight, truck_weights) {
    const currentBridge = [];
    let currentWeight = 0;

    let timer = 0;
    while (truck_weights.length > 0 || currentBridge.length > 0) {
        timer++;

        if (currentBridge.length > 0 && timer - currentBridge[0].time === bridge_length) {
            currentWeight -= currentBridge.shift().weight;
        }

        const tryTruck = truck_weights[0];
        if (weight >= currentWeight + tryTruck) {
            currentWeight += tryTruck;
            currentBridge.push({
                time: timer,
                weight: tryTruck,
            });
            truck_weights.shift();
        }
    }

    return timer;
}
