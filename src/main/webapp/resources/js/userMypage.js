//mypage.jsp 카테고리 클릭 시 필요한 값 받아오기
history.replaceState({},null,location.pathname);
$(document).ready(function(){
   $('#check1').on('click', function(){
      $('#category').val(1);
   });
   $('#check2').on('click', function(){
      $('#category').val(2);
   });
   $('#check3').on('click', function(){
      $('#category').val(3);
   });
   $('#check4').on('click', function(){
      $('#category').val(4);
   });
   
   $('#check5').on('click', function(){
      $('#review').val(5);
   });
   $('#check6').on('click', function(){
      $('#review').val(6);
   });
   $('#check7').on('click', function(){
      $('#zzim').val(7);
   });
   $('#check8').on('click', function(){
      $('#zzim').val(8);
   });
});

//mypagemodify.jsp 사진 삭제 클릭 시, 기본 이미지 넣기
$(document).ready(function(){
      $('#delete').on('click', function(){
      changeImg();
      var deleteResult = $('#delete_result').val();
      var m_gender = $('#m_gender').val();
      if(m_gender == 1){
         $('#delete_result').val(1);
      }else if(m_gender == 2){
         $('#delete_result').val(2);
      }else if(m_gender == 3){
         $('#delete_result').val(3);
      }else{
         $('#delete_result').val(4);
      }
      var file = document.getElementById("file");
      file.setAttribute("type","hidden");
   });
   
   //여자남자 버튼 활성화
   var m_gender = $('#m_gender').val();
   var b_male = document.getElementById("male");
   var b_female = document.getElementById("female");
   if(m_gender == 1 || m_gender==3){
      b_female.setAttribute("disabled", "disabled");
      b_male.setAttribute("onClick", "return(false);");
   }else{
      b_male.setAttribute("disabled", "disabled");
      b_female.setAttribute("onClick", "return(false);");
   }
});



//마이페이지 수정 시, 기본 프로필 이미지로 src 변경 함수
function changeImg(){
   var img1 = document.getElementById("img1");
   var m_gender = document.getElementById("m_gender").value;
   if(m_gender == '1' || m_gender == '3'){
      img1.src="/resources/img/profile/base_m.png";
   }else{
      img1.src="/resources/img/profile/base_w.png";
   }
}

