/*TMODJS:{"version":6,"md5":"0c8394a47a996dced098656e553638b7"}*/
template('titlesyllabus',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,grade=$data.grade,major=$data.major,level=$data.level,fileName=$data.fileName,path=$data.path,$out='';$out+='<div class="schedule-content-btn" id="syllabus"> <p>';
$out+=$escape(grade);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(level=0?'本科':'专科');
$out+=' ';
$out+=$escape(fileName);
$out+='</p> </div> <div class="schedule-content-message"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe > </div>';
return new String($out);
});