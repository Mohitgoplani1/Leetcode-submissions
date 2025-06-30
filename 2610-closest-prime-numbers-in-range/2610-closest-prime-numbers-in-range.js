var closestPrimes = function(left, right) {
    const isPrime = new Array(right + 1).fill(true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (let i = 2; i * i <= right; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j <= right; j += i) {
                isPrime[j] = false;
            }
        }
    }

    let prev = -1;
    let minDiff = Infinity;
    let result = [-1, -1];

    for (let i = left; i <= right; i++) {
        if (isPrime[i]) {
            if (prev !== -1 && i - prev < minDiff) {
                minDiff = i - prev;
                result = [prev, i];
            }
            prev = i;
        }
    }

    return result;
};