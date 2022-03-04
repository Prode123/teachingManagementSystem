/*TMODJS:{"version":3,"md5":"07c67430f945ba8f87facb69bec40d17"}*/
template('training',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,major=$data.major,level=$data.level,grade=$data.grade,fileName=$data.fileName,path=$data.path,$out='';$out+='<div class="schedule-content-btn" id="training"> <p>';
$out+=$escape(faculty);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(level=0?'专科':'本科');
$out+=' ';
$out+=$escape(grade+'级');
$out+=' ';
$out+=$escape(fileName);
$out+='</p> </div> <div class="schedule-content-message"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe> </div>';
return new String($out);
});