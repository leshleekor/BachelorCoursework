// Human Interface Device
Hid hi;
HidMsg msg;


1 => int device;
// device number

hi.openKeyboard(device);
// 연결이 된 경우 true, 연결이 안된 경우 false 리턴

if(!hi.openKeyboard(device)) {
  <<< "Can't open this device! :",  hi.name() >>>;
  me.exit();
}
<<< "Keboard is ready :", hi.name() >>>;

BeeThree organ => JCRev r => dac;

while(true) {
  hi => now; // 이벤트 발생 기다림.
  if(hi.recv(msg)) {
    if(msg.isButtonDown()) {
      <<< "key down:", msg.ascii >>>;
      float freq;
      if(msg.ascii == 49) {
          60 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 50) {
          62 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 51) {
          64 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 52) {
          65 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 53) {
          67 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 54) {
          69 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 55) {
          71 => Std.mtof => organ.freq;
      }
      else if(msg.ascii == 56) {
          72 => Std.mtof => organ.freq;
      }
      else continue;
      // msg.ascii => Std.mtof => organ.freq;
      1 => organ.noteOn;
      80::ms => now;
    }
    else {
      <<< "key up: ", msg.ascii >>>;
      1 => organ.noteOff;
    }
  }
}