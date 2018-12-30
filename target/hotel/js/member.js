$(document).ready(function(){
	var room = JSON.parse(data2);
	var type = ["标准单人房","标准双人房","豪华单人房","豪华双人房"];
	for(var i=0;i<room.length;i++){
		$('#table-1 tbody').append("<tr><td>"+room[i].username+"</td><td>"+"<select class='select_1'><option value = '1'>标准单人房</option><option value = '2'>标准双人房</option><option value = '3'>豪华单人房</option><option value = '4'>豪华双人房</option></select>"+"</td><td><label>"+room[i].startDate+"</label> 至<br><label>"+room[i].endDate+"</label></td><td>"+room[i].price+"</td><td><input type='button' value='修改' class='bt'></td><td><input type='button' value='退订' class='bt'></td></tr>");
		for(var j = 0;j<type.length;j++){
			if(room[i].roomType == type[j]){
				$('.select_1:last').children('option').eq(j).attr('selected',"selected");
				break;
			}
		}
	}
});