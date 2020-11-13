public class BPM {
  static dur qN, eN, sN, tN;
  fun void tempo(float beat) {
    60.0/(beat) => float SPB;
    SPB::second => qN;
    qn*0.5 => eN;
    eN*0.5 => sN;
    sN*0.5 => tN;
  }
}
