function checkPw() {
	const pw1 = document.getElementById("u_pw").value;
	const pw2 = document.getElementById("pw2").value;

	if (pw1 == pw2) {
		document.getElementById("pwCheckMsg").innerHTML = "비밀번호가 일치합니다.";
		document.getElementById("pwCheckMsg").style.color = "blue";
	} else {
		document.getElementById("pwCheckMsg").innerHTML = "비밀번호가 일치하지 않습니다.";
		document.getElementById("pwCheckMsg").style.color = "red";
	}
};