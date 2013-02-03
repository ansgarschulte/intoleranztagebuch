function XQ(){}
function SQ(){}
function l2(){}
function o2(){}
function s2(){}
function q2(){}
function e4(){}
function Yvb(){}
function Xvb(){}
function c7b(){}
function s7b(){}
function w7b(){}
function A7b(){}
function E7b(){}
function t7b(b){this.b=b}
function x7b(b){this.b=b}
function B7b(b){bb();this.b=b}
function q7b(b,c){b.enctype=c;b.encoding=c}
function PAb(b,c){b.onload=Soc(function(){c.Sf()})}
function f4(){var b;this.Ob=(b=$doc.createElement(Hqc),b.type=Rqc,b)}
function e7b(b){ehb(b.n,false);b.o||(b.e.Ob[Dqc]=true,undefined);b.d=false}
function f7b(b){ehb(b.n,true);b.e.Ob[Dqc]=false;b.d=true;if(b.o){d7b(b);b.o=false}}
function d7b(b){if(b.p){$doc.body.removeChild(b.p);b.p.onload=null;b.p=null}}
function i7b(b,c){if(b.f!=c){b.f=c;if(b.f){y$(b.e,1024);y$(b.e,2048)}}i$(b.Ob,'v-upload-immediate',b.f)}
function h7b(b){$$(b.k,b.n);$$(b.k,b.e);b.e=new F7b(b);b.e.Ob.name=b.j+wxc;b.e.Ob[Dqc]=!b.d;c3(b.k,b.e);c3(b.k,b.n);b.f&&y$(b.e,1024)}
function ZQ(){VQ=new XQ;Ub((Sb(),Rb),3);!!$stats&&$stats(xc(uxc,_oc,-1,-1));VQ.Mc();!!$stats&&$stats(xc(uxc,bxc,-1,-1))}
function WQ(){var b,c,d;while(TQ){d=nb;TQ=TQ.b;!TQ&&(UQ=null);if(!d){(vtb(),utb).qg(EF,new Yvb);Okb()}else{try{(vtb(),utb).qg(EF,new Yvb);Okb()}catch(b){b=MI(b);if(br(b,37)){c=b;Rqb.Be(c)}else throw b}}}}
function F7b(b){var c;this.b=b;this.Ob=(c=$doc.createElement(Hqc),c.type='file',c);this.Ob[sqc]='gwt-FileUpload';this.c=new s2;this.c.d=this;this.Lb==-1?$X(this.Ob,4096|(this.Ob.__eventBits||0)):(this.Lb|=4096)}
function j7b(b){if(b.e.Ob.value.length==0||b.o||!b.d){Rqb.De('Submit cancelled (disabled, no file or already submitted)');return}dib(b.b);b.c.submit();b.o=true;Rqb.De('Submitted form');e7b(b);b.q=new B7b(b);db(b.q,800)}
function r2(b,c){var d;switch($Y(c.type)){case 1024:if(!b.b){b.c=true;return false}break;case 4096:if(b.c){b.b=true;b.d.Ob.dispatchEvent((d=$doc.createEvent(vxc),d.initEvent(vpc,false,true),d));b.b=false;b.c=false}}return true}
function g7b(b){var c;if(!b.p){c=$doc.createElement(Pqc);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.j+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||Woc;b.p=Rd(c);$doc.body.appendChild(b.p);b.c.target=b.j+'_TGT_FRAME';PAb(b.p,b)}}
function k7b(){this.Ob=$doc.createElement('form');this.e=new F7b(this);this.k=new f3;this.g=new f4;this.c=this.Ob;q7b(this.Ob,xxc);this.c.method='post';j1(this,this.k);c3(this.k,this.g);c3(this.k,this.e);this.n=new hhb;p$(this.n,new t7b(this),(ek(),ek(),dk));c3(this.k,this.n);this.Ob[sqc]='v-upload';this.Lb==-1?$X(this.Ob,241|(this.Ob.__eventBits||0)):(this.Lb|=241)}
var wxc='_file',yxc='buttoncaption',uxc='runCallbacks3';_=XQ.prototype=SQ.prototype=new J;_.gC=function YQ(){return Cv};_.Mc=function aR(){WQ()};_.cM={};_=l2.prototype=new OZ;_.gC=function m2(){return Kw};_.Rc=function n2(b){r2(this.c,b)&&t$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.c=null;_=o2.prototype=new J;_.gC=function p2(){return Jw};_.cM={};_=s2.prototype=q2.prototype=new o2;_.gC=function t2(){return Iw};_.cM={};_.b=false;_.c=false;_.d=null;_=f4.prototype=e4.prototype=new OZ;_.gC=function g4(){return Zw};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=Yvb.prototype=Xvb.prototype=new J;_.Oe=function Zvb(){return new k7b};_.gC=function $vb(){return HA};_.cM={137:1};_=k7b.prototype=c7b.prototype=new g1;_.gC=function l7b(){return EF};_.hd=function m7b(){s$(this);!!this.b&&g7b(this)};_.Rc=function n7b(b){($Y(b.type)&241)>0&&(ysb(this.b.I,b,this,null),undefined);t$(this,b)};_.jd=function o7b(){u$(this);this.o||d7b(this)};_.Sf=function p7b(){psb((Gc(),Fc),new x7b(this))};_._d=function r7b(b,c){var d;if(lib(c,this,b,true)){return}if('notStarted' in b[1]){db(this.q,400);return}if('forceSubmit' in b[1]){j7b(this);return}i7b(this,Boolean(b[1][Nrc]));this.b=c;this.j=b[1][Lqc];this.i=b[1]['nextid'];d=iib(c,b[1][Qrc][Nvc]);this.c.action=d;if(yxc in b[1]){ghb(this.n,b[1][yxc]);this.n.Ob.style.display=Woc}else{this.n.Ob.style.display=opc}this.e.Ob.name=this.j+wxc;if(Dqc in b[1]||Krc in b[1]){e7b(this)}else if(!Boolean(b[1][csc])){f7b(this);g7b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.b=null;_.c=null;_.d=true;_.f=false;_.i=0;_.j=null;_.n=null;_.o=false;_.p=null;_.q=null;_=t7b.prototype=s7b.prototype=new J;_.gC=function u7b(){return AF};_.hc=function v7b(b){this.b.f?(this.b.e.Ob.click(),undefined):j7b(this.b)};_.cM={12:1,39:1};_.b=null;_=x7b.prototype=w7b.prototype=new J;_.Zb=function y7b(){if(this.b.o){if(this.b.b){!!this.b.q&&cb(this.b.q);Rqb.De('VUpload:Submit complete');dib(this.b.b)}h7b(this.b);this.b.o=false;f7b(this.b);this.b.Kb||d7b(this.b)}};_.gC=function z7b(){return BF};_.cM={3:1,14:1};_.b=null;_=B7b.prototype=A7b.prototype=new $;_.gC=function C7b(){return CF};_.Vb=function D7b(){Rqb.De('Visiting server to see if upload started event changed UI.');Chb(this.b.b,this.b.j,'pollForStart',Woc+this.b.i,true,105)};_.cM={65:1};_.b=null;_=F7b.prototype=E7b.prototype=new l2;_.gC=function G7b(){return DF};_.Rc=function H7b(b){r2(this.c,b)&&t$(this,b);if($Y(b.type)==1024){this.b.f&&this.b.e.Ob.value!=null&&!Cgc(Woc,this.b.e.Ob.value)&&j7b(this.b)}else if((Zlb(),!Ylb&&(Ylb=new vmb),Zlb(),Ylb).b.i&&$Y(b.type)==2048){this.b.e.Ob.click();this.b.e.Ob.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.b=null;var Cv=hfc(Owc,'AsyncLoader3'),Kw=hfc(Rwc,'FileUpload'),Jw=hfc(Rwc,'FileUpload$FileUploadImpl'),Iw=hfc(Rwc,'FileUpload$FileUploadImplOpera'),Zw=hfc(Rwc,'Hidden'),HA=hfc(Ywc,'WidgetMapImpl$4$1'),AF=hfc(Xwc,'VUpload$1'),BF=hfc(Xwc,'VUpload$2'),CF=hfc(Xwc,'VUpload$3'),DF=hfc(Xwc,'VUpload$MyFileUpload');Soc(ZQ)();