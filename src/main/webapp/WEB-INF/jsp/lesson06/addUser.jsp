<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX을 사용할려면 반드시 JQUERY원본 필요 slim으로 된 형태의 jquery형식의 문법은 삭제하고 원본을 추가 -->
  <script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<%-- <form method="post" action="lessson06/ex01/add-user">--%>
			<div class="form-group">
				<label for="name"><b>이름</b></label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예)20190101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="10"></textarea>
			</div>
			
			<!-- <input type="submit" class="btn btn-success" value="추가"> -->
			<%--★★★★★★★★★ajax통신 일때는 반드시 button타입으로 저장한다 --%>
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
		<%--</form> --%>
	</div>
	<script>
		$(document).ready(function(){// 돔 트리 완성을 해야 되니싸 documnet 같은 함수를 작성한다
			 //1. jquery submit 기능 이용하기(from태그)
			 /* $("form").on("submit", function(e){
				e.preventDefault(); // 폼태그 동작 막음
				//alert("폼 태그 동작");
				
				// alert까지 도달하면 submit수행 되고있다
				
				
				//validation check -> 유효성 컴사 대상과 항목 작동 등을 정의 한다
				let name = $("#name").val().trim();//trim함수 적용은 앞뒤 여백 제거를 위한것
				if(name == ""){
					alert("이름을 입력하세요");
					return false; // ★★★★★★★★★submit 않함 form태그 일때는 return을 false로 해야된다
				}
				
				let yyyymmdd = $('#yyyymmdd').val().trim();
				if(yyyymmdd.length < 1){
					alert("생년월일 입력하세요");
					return false;// submit 않함 ★★★★★★★★★form태그 일때는 return을 false로 해야된다
				}
				let email = $('input[name=email]').val().trim();
				if(!email){
					alert("이메일을 입력하세요");
					return false;// submit 않함 ★★★★★★★★★form태그 일때는 return을 false로 해야된다
				} 
			
				
			});  */
			
			//2. jquery의 ajax 통신 이용하기
			$('#joinBtn').on('click', function(){
				//alert("버튼 클릭");
				
				
				//validation check
				let name = $("#name").val().trim();
				if(name == ""){
					alert("이름을 입력하세요");
					return; // submit 않함 form태그 일때는 return을 false로 해야된다
				}
				
				let yyyymmdd = $('#yyyymmdd').val().trim();
				if(yyyymmdd.length < 1){
					alert("생년월일 입력하세요");
					return;// submit 않함 form태그 일때는 return을 false로 해야된다
				}
				let email = $('input[name=email]').val().trim();
				if(!email){
					alert("이메일을 입력하세요");
					return;
				}
				let introduce = $('#introduce').val();
				
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				//AJAX서버 요청
				$.ajax({
					//request
					type:"post"
					, url:"/lesson06/ex01/add-user"
					, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}// json string
					
					//response
					//call back 함수 -> 한번 실행시키고 다시 리턴을 해주는것
					, success:function(data){//data: response 결과 응답(jason string)=> dictionary object 
						// 서버 처리후 에러가 없을 떄 수행됨
						//alert(data);
					//data는 json string => object 변환된 형태로 사용할수있다
					// jquery의 ajax의 함수기능
					alert(data.code);
					alert(data.result);
					if(data == "성공"){
							location.href = "/lesson06/ex01/get-latest-user";
						}
					}
					, complete:function(data){
						//성공이든 실패든 무조건 불려짐 => 않씀~~~
						alert(data);
					}
					, error:function(request, status, error){
						//error일떄 수행(400,500.....)
						alert(request);
						alert(status);
						alert(error);
					}
				});				
			});
			
		});

	</script>
	
	
	
	
	
</body>
</html>