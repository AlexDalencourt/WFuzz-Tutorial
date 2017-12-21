var loginForm = document.querySelector("#loginForm");
var loginFormRaw = document.querySelector("#loginFormRaw");
var errorLogin = document.querySelector("#errorLogin");

var userName;

function connect(event) {
	event.preventDefault();
	
	$.post(
		"http://localhost:8080/login",
		{
			login : $("#login").val(),
			pwd : $("#pwd").val()
		},
		function(data, status){
			if(status == "success"){
				loginFormRaw.classList.add("hidden");
				errorLogin.classList.add("hidden");
				document.querySelector("#filesList").classList.remove("hidden");
				userName = $("#login").val();
				listFiles();
			}
		}
	).fail(function(xhr, status, error){errorLogin.classList.remove("hidden")});
}

function listFiles(){
	$.get(
		"http://localhost:8080/filesList/" + userName,
		function(data, status){
			if(status == "success"){
				var divroot = document.querySelector("#files");
				data.forEach(function(element){
					var linkElement = document.createElement('a');
					var textElement = document.createTextNode(element);
					linkElement.href = "/file/" + element;
					linkElement.classList.add("list-group-item");
					linkElement.appendChild(textElement);
					divroot.appendChild(linkElement);
				});
			}
		}
	);
}

loginForm.addEventListener("submit", connect, true);
