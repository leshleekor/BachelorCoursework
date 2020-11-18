// Human Interface Device
Hid hi;
HidMsg msg;


0 => int device;
// device number

// hi.openMouse(device);
// 연결이 된 경우 true, 연결이 안된 경우 false 리턴

if(!hi.openMouse(device)) {
  <<< "Can't open this device! :",  hi.name() >>>;
  me.exit();
}
<<< "Mouse is ready :", hi.name() >>>;

SndBuf snare => dac;
me.dir() + "audio/snare_01.wav" => snare.read;
snare.samples() => snare.pos;

while(true) {
  hi => now; // 이벤트 발생 기다림.
  if(hi.recv(msg)) {
    if(msg.isButtonDown()) {
      <<< "button down:", msg.ascii >>>;
      0 => snare.pos;
  } else if(msg.isMouseMotion()) {
      if(msg.deltaX != 0) {
          <<< "mouse deltaX: ", msg.deltaX >>>;
          msg.deltaX/20 => snare.rate;
      }
  }
}
}