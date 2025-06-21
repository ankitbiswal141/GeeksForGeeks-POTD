function maxThievesCaught(arr, k) {
  let police = [];
  let thieves = [];

  for (let i = 0; i < arr.length; i++) {
      if (arr[i] === 'P') police.push(i);
      else if (arr[i] === 'T') thieves.push(i);
  }

  let i = 0, j = 0, caught = 0;

  while (i < police.length && j < thieves.length) {
      let p = police[i];
      let t = thieves[j];

      if (Math.abs(p - t) <= k) {
          caught++;
          i++;
          j++;
      } else if (p < t) {
          i++;
      } else {
          j++;
      }
  }

  return caught;
}

let arr = ['P', 'T', 'T', 'P', 'T'];
let k = 1;
console.log("Maximum thieves caught:", maxThievesCaught(arr, k)); // Output: 2