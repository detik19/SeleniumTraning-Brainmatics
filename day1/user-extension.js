Selenium.prototype.doNothing = function(){



}

Selenium.prototype.doToday = function(locator){
	var d= new Date();
	//untuk tanggal
	var tgl=d.getDate();
	if(tgl<10){
		tgl='0'+tgl;
		
	}
	//untuk bulan 
	var bln =d.getMonth();
	if(bln < 10){
		bln='0'+(bln+1);
	}
	var thn=d.getFullYear();
	var tanggal=tgl+"/"+bln+"/"+thn;
	this.doType(locator, tanggal);


}

Selenium.prototype.doCountDown=function(locator){
	var _second = 1000;
    var _minute = _second * 60;
    var _hour = _minute * 60;
    var _day = _hour * 24;
	var finalday=new Date('06/06/2016');
	var now=new Date();
	
	var distance = finalday - now;
	var days = Math.floor(distance / _day);
	this.doType(locator,days);
}