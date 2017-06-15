function setTitle(title) {
	document.title = title || '电子送达系统';
}
function check(id){
	if(!$('#'+id+' input').val()){
		$('#'+id).addClass('has-error');
		return false;
	}else{
		$('#'+id).removeClass('has-error');
		return true;
	}
}
function setCheck(ids){
	ids.map(function(id){
		$('#'+id+' input').blur(function(){
			check(id);
		})
	});
}