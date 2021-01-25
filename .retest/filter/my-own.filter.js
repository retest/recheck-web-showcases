var baseUrl = /http[s]?:\/\/[\w.:\d\-]*/;

function matches(element, diff) {
	print("diff: " + diff);
	if (diff.key == "opacity") {
		return (Math.abs(diff.expected - diff.actual) <= 10);
	}
	if (diff.key == "font-family" && diff.expected != null && diff.actual != null) {
		var expected = diff.expected.replace(/[^\x00-\x7F]/g, "").replace(/"/g, "");
		var actual = diff.actual.replace(/[^\x00-\x7F]/g, "").replace(/"/g, "");
		return actual === expected;
	}
	if (diff.expected != null && diff.actual != null) {
		cleanExpected = diff.expected.replace(baseUrl, '');
		cleanActual = diff.actual.replace(baseUrl, '');
		return cleanExpected === cleanActual;
	}
	return false;
}
