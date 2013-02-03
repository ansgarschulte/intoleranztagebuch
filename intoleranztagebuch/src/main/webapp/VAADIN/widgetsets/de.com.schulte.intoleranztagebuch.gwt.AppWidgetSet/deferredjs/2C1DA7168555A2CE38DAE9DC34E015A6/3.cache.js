function jR(){}
function eR(){}
function G2(){}
function t4(){}
function zwb(){}
function ywb(){}
function F7b(){}
function V7b(){}
function Z7b(){}
function b8b(){}
function f8b(){}
function W7b(b){this.b=b}
function $7b(b){this.b=b}
function c8b(b){bb();this.b=b}
function T7b(b,c){b.enctype=c;b.encoding=c}
function qBb(b,c){b.onload=tpc(function(){c.Sf()})}
function H7b(b){Hhb(b.n,false);b.o||(b.e.Ob[hrc]=true,undefined);b.d=false}
function I7b(b){Hhb(b.n,true);b.e.Ob[hrc]=false;b.d=true;if(b.o){G7b(b);b.o=false}}
function G7b(b){if(b.p){$doc.body.removeChild(b.p);b.p.onload=null;b.p=null}}
function u4(){var b;this.Ob=(b=$doc.createElement(lrc),b.type=urc,b)}
function g8b(b){var c;this.b=b;this.Ob=(c=$doc.createElement(lrc),c.type='file',c);this.Ob[Yqc]='gwt-FileUpload'}
function L7b(b,c){if(b.f!=c){b.f=c;if(b.f){S$(b.e,1024);S$(b.e,2048)}}C$(b.Ob,'v-upload-immediate',b.f)}
function K7b(b){s_(b.k,b.n);s_(b.k,b.e);b.e=new g8b(b);b.e.Ob.name=b.j+$xc;b.e.Ob[hrc]=!b.d;r3(b.k,b.e);r3(b.k,b.n);b.f&&S$(b.e,1024)}
function lR(){hR=new jR;Ub((Sb(),Rb),3);!!$stats&&$stats(xc(Zxc,Cpc,-1,-1));hR.Mc();!!$stats&&$stats(xc(Zxc,Gxc,-1,-1))}
function iR(){var b,c,d;while(fR){d=nb;fR=fR.b;!fR&&(gR=null);if(!d){(Ytb(),Xtb).qg(SF,new zwb);plb()}else{try{(Ytb(),Xtb).qg(SF,new zwb);plb()}catch(b){b=$I(b);if(pr(b,37)){c=b;srb.Be(c)}else throw b}}}}
function M7b(b){if(b.e.Ob.value.length==0||b.o||!b.d){srb.De('Submit cancelled (disabled, no file or already submitted)');return}Gib(b.b);b.c.submit();b.o=true;srb.De('Submitted form');H7b(b);b.q=new c8b(b);db(b.q,800)}
function J7b(b){var c;if(!b.p){c=$doc.createElement(src);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.j+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||xpc;b.p=Td(c);$doc.body.appendChild(b.p);b.c.target=b.j+'_TGT_FRAME';qBb(b.p,b)}}
function N7b(){this.Ob=$doc.createElement('form');this.e=new g8b(this);this.k=new u3;this.g=new u4;this.c=this.Ob;T7b(this.Ob,_xc);this.c.method='post';D1(this,this.k);r3(this.k,this.g);r3(this.k,this.e);this.n=new Khb;J$(this.n,new W7b(this),(sk(),sk(),rk));r3(this.k,this.n);this.Ob[Yqc]='v-upload';this.Lb==-1?CZ(this.Ob,241|(this.Ob.__eventBits||0)):(this.Lb|=241)}
var $xc='_file',ayc='buttoncaption',Zxc='runCallbacks3';_=jR.prototype=eR.prototype=new J;_.gC=function kR(){return Qv};_.Mc=function oR(){iR()};_.cM={};_=G2.prototype=new g$;_.gC=function H2(){return Xw};_.Rc=function I2(b){N$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=u4.prototype=t4.prototype=new g$;_.gC=function v4(){return kx};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=zwb.prototype=ywb.prototype=new J;_.Oe=function Awb(){return new N7b};_.gC=function Bwb(){return VA};_.cM={137:1};_=N7b.prototype=F7b.prototype=new A1;_.gC=function O7b(){return SF};_.hd=function P7b(){M$(this);!!this.b&&J7b(this)};_.Rc=function Q7b(b){(mZ(b.type)&241)>0&&(_sb(this.b.I,b,this,null),undefined);N$(this,b)};_.jd=function R7b(){O$(this);this.o||G7b(this)};_.Sf=function S7b(){Ssb((Gc(),Fc),new $7b(this))};_._d=function U7b(b,c){var d;if(Oib(c,this,b,true)){return}if('notStarted' in b[1]){db(this.q,400);return}if('forceSubmit' in b[1]){M7b(this);return}L7b(this,Boolean(b[1][ssc]));this.b=c;this.j=b[1][prc];this.i=b[1]['nextid'];d=Lib(c,b[1][vsc][qwc]);this.c.action=d;if(ayc in b[1]){Jhb(this.n,b[1][ayc]);this.n.Ob.style.display=xpc}else{this.n.Ob.style.display=Spc}this.e.Ob.name=this.j+$xc;if(hrc in b[1]||psc in b[1]){H7b(this)}else if(!Boolean(b[1][Isc])){I7b(this);J7b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.b=null;_.c=null;_.d=true;_.f=false;_.i=0;_.j=null;_.n=null;_.o=false;_.p=null;_.q=null;_=W7b.prototype=V7b.prototype=new J;_.gC=function X7b(){return OF};_.hc=function Y7b(b){this.b.f?(this.b.e.Ob.click(),undefined):M7b(this.b)};_.cM={12:1,39:1};_.b=null;_=$7b.prototype=Z7b.prototype=new J;_.Zb=function _7b(){if(this.b.o){if(this.b.b){!!this.b.q&&cb(this.b.q);srb.De('VUpload:Submit complete');Gib(this.b.b)}K7b(this.b);this.b.o=false;I7b(this.b);this.b.Kb||G7b(this.b)}};_.gC=function a8b(){return PF};_.cM={3:1,14:1};_.b=null;_=c8b.prototype=b8b.prototype=new $;_.gC=function d8b(){return QF};_.Vb=function e8b(){srb.De('Visiting server to see if upload started event changed UI.');dib(this.b.b,this.b.j,'pollForStart',xpc+this.b.i,true,105)};_.cM={65:1};_.b=null;_=g8b.prototype=f8b.prototype=new G2;_.gC=function h8b(){return RF};_.Rc=function i8b(b){N$(this,b);if(mZ(b.type)==1024){this.b.f&&this.b.e.Ob.value!=null&&!dhc(xpc,this.b.e.Ob.value)&&M7b(this.b)}else if((Amb(),!zmb&&(zmb=new Ymb),Amb(),zmb).b.i&&mZ(b.type)==2048){this.b.e.Ob.click();this.b.e.Ob.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.b=null;var Qv=Kfc(rxc,'AsyncLoader3'),Xw=Kfc(uxc,'FileUpload'),kx=Kfc(uxc,'Hidden'),VA=Kfc(Bxc,'WidgetMapImpl$4$1'),OF=Kfc(Axc,'VUpload$1'),PF=Kfc(Axc,'VUpload$2'),QF=Kfc(Axc,'VUpload$3'),RF=Kfc(Axc,'VUpload$MyFileUpload');tpc(lR)();