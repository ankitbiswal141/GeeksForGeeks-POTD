function sortString(s) {
  // Separate uppercase and lowercase characters
  const upper = [];
  const lower = [];
  
  for (let c of s) {
      if (c >= 'A' && c <= 'Z') {
          upper.push(c);
      } else {
          lower.push(c);
      }
  }

  // Sort both arrays
  upper.sort();
  lower.sort();
  
  // Rebuild the string by placing characters back in the original order
  let result = '';
  let upperIndex = 0, lowerIndex = 0;
  
  for (let c of s) {
      if (c >= 'A' && c <= 'Z') {
          result += upper[upperIndex++];
      } else {
          result += lower[lowerIndex++];
      }
  }

  return result;
}

// Test cases here