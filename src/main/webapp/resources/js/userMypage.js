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




