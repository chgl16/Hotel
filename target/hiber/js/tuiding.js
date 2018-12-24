$(document).ready(function(){
	var room = JSON.parse(data);
	for(var i=0;i<room.length;i++){
		$('#table-1 tbody').append("<tr><td>"+room[i].roomType+"</td><td><label>"+room[i].startDate+"</label> 至<br><label>"+room[i].endDate+"</label></td><td>"+room[i].price+"</td><td><input type='button' value='退订' class='bt'></td></tr>");
	}
});