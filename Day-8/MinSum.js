function minSum(arr) {
  arr.sort((a, b) => a - b);

  let num1 = '';
  let num2 = '';

  for (let i = 0; i < arr.length; i++) {
      if (i % 2 === 0)
          num1 += arr[i];
      else
          num2 += arr[i];
  }

  // Remove leading zeros
  num1 = num1.replace(/^0+/, '') || '0';
  num2 = num2.replace(/^0+/, '') || '0';

  return addStrings(num1, num2);
}

function addStrings(a, b) {
  let i = a.length - 1, j = b.length - 1;
  let carry = 0;
  let res = [];

  while (i >= 0 || j >= 0 || carry > 0) {
      let sum = carry;
      if (i >= 0) sum += +a[i--];
      if (j >= 0) sum += +b[j--];
      res.push(sum % 10);
      carry = Math.floor(sum / 10);
  }

  return res.reverse().join('');
}