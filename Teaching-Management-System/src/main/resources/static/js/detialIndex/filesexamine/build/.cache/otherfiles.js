/*TMODJS:{"version":7,"md5":"2e173aedff4294a3f655071aa59e0747"}*/
template('otherfiles',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,major=$data.major,grade=$data.grade,fileName=$data.fileName,fileType=$data.fileType,path=$data.path,$out='';$out+='<div class="otherfiles" id="files"> <p>';
$out+=$escape(faculty);
$out+=' ';
$out+=$escape(major);
$out+=' ';
$out+=$escape(grade+'级');
$out+=' ';
$out+=$escape(fileName);
$out+=' ';
$out+=$escape(fileType);
$out+=' <button class="nopass">不通过</button> <button class="pass">通过</button> </p> </div> <div class="file-content"> <iframe src="';
$out+=$escape(path);
$out+='" id="" width="100%" height="100%">此处为PDF文档</iframe> </div>';
return new String($out);
});