function isPalindrome(s) {
  let left = 0, right = s.length - 1;
  while (left < right) {
      if (s[left] !== s[right]) return false;
      left++;
      right--;
  }
  return true;
}

function backtrack(s, start, temp, result) {
  if (start === s.length) {
      result.push([...temp]);
      return;
  }

  for (let i = start + 1; i <= s.length; i++) {
      let substr = s.slice(start, i);
      if (isPalindrome(substr)) {
          temp.push(substr);
          backtrack(s, i, temp, result);
          temp.pop();
      }
  }
}

function partition(s) {
  let result = [];
  backtrack(s, 0, [], result);
  return result;
}

// Test cases