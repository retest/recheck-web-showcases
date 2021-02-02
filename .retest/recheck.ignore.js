// Here you can implement ignore rules for recheck in javascript.
// Please do not delete this file, even if it is empty.

// You can implement either of these two functions:
// function matches(element) {}
// function matches(element, diff) {}

// You can find more details and example rules at: 
// https://retest.github.io/docs/recheck/how-ignore-works-in-recheck/



// Example ignoring the base URL
//
//var baseUrl = /http[s]?:\/\/[\w.:\d\-]*/;
//function matches(element, diff) {
//	if (diff.expected != null && diff.actual != null) {
//		cleanExpected = diff.expected.replace(baseUrl, '');
//		cleanActual = diff.actual.replace(baseUrl, '');
//		return cleanExpected === cleanActual;
//	}
//	return false;
//}
