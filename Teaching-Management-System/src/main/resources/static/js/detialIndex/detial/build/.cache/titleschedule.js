/*TMODJS:{"version":12,"md5":"6a3e35c7be8fcab35a039d88f7cd8a0d"}*/
template('titleschedule',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,grade=$data.grade,major=$data.major,level=$data.level,fileName=$data.fileName,fileType=$data.fileType,path=$data.path,$out='';$out+='<div class="schedule-content-btn" id="teachschedule"> <p>';
$out+=$escape(grade);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(level=0?'本科':'专科');
$out+=' ';
$out+=$escape(fileName);
$out+=' ';
$out+=$escape(fileType);
$out+='</p> </div> <div class="schedule-content-message"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe> </div>';
return new String($out);
});