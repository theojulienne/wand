/* Generated By:JJTree&JavaCC: Do not edit this line. WandParserTokenManager.java */
package wand.parser;

/** Token Manager. */
public class WandParserTokenManager implements WandParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x20010000000L) != 0L)
            return 15;
         if ((active0 & 0xffdfc02000070380L) != 0L || (active1 & 0x3L) != 0L)
         {
            jjmatchedKind = 67;
            return 7;
         }
         return -1;
      case 1:
         if ((active0 & 0xfadfc00000070280L) != 0L || (active1 & 0x3L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 67;
               jjmatchedPos = 1;
            }
            return 7;
         }
         if ((active0 & 0x500002000000100L) != 0L)
            return 7;
         return -1;
      case 2:
         if ((active0 & 0x3adfc00000070280L) != 0L || (active1 & 0x3L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 67;
               jjmatchedPos = 2;
            }
            return 7;
         }
         if ((active0 & 0xc000000000000100L) != 0L)
            return 7;
         return -1;
      case 3:
         if ((active0 & 0xa8dfc00000040200L) != 0L || (active1 & 0x3L) != 0L)
         {
            jjmatchedKind = 67;
            jjmatchedPos = 3;
            return 7;
         }
         if ((active0 & 0x1200000000030080L) != 0L)
            return 7;
         return -1;
      case 4:
         if ((active0 & 0x2808000000040200L) != 0L || (active1 & 0x1L) != 0L)
            return 7;
         if ((active0 & 0x80d7c00000000000L) != 0L || (active1 & 0x2L) != 0L)
         {
            jjmatchedKind = 67;
            jjmatchedPos = 4;
            return 7;
         }
         return -1;
      case 5:
         if ((active0 & 0x8005800000000000L) != 0L || (active1 & 0x2L) != 0L)
         {
            jjmatchedKind = 67;
            jjmatchedPos = 5;
            return 7;
         }
         if ((active0 & 0xd2400000000000L) != 0L)
            return 7;
         return -1;
      case 6:
         if ((active0 & 0x8000800000000000L) != 0L)
            return 7;
         if ((active0 & 0x5000000000000L) != 0L || (active1 & 0x2L) != 0L)
         {
            jjmatchedKind = 67;
            jjmatchedPos = 6;
            return 7;
         }
         return -1;
      case 7:
         if ((active0 & 0x1000000000000L) != 0L)
         {
            jjmatchedKind = 67;
            jjmatchedPos = 7;
            return 7;
         }
         if ((active0 & 0x4000000000000L) != 0L || (active1 & 0x2L) != 0L)
            return 7;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 87;
         return jjMoveStringLiteralDfa1_0(0x1080000000L, 0x0L);
      case 37:
         jjmatchedKind = 42;
         return jjMoveStringLiteralDfa1_0(0x20000000L, 0x0L);
      case 38:
         jjmatchedKind = 81;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x8200L);
      case 40:
         return jjStopAtPos(0, 19);
      case 41:
         return jjStopAtPos(0, 20);
      case 42:
         jjmatchedKind = 40;
         return jjMoveStringLiteralDfa1_0(0x8000000L, 0x0L);
      case 43:
         jjmatchedKind = 38;
         return jjMoveStringLiteralDfa1_0(0x2800000L, 0x0L);
      case 44:
         return jjStopAtPos(0, 68);
      case 45:
         jjmatchedKind = 39;
         return jjMoveStringLiteralDfa1_0(0x5000000L, 0x0L);
      case 46:
         return jjStopAtPos(0, 71);
      case 47:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x10000000L, 0x0L);
      case 58:
         return jjStopAtPos(0, 53);
      case 59:
         return jjStopAtPos(0, 66);
      case 60:
         jjmatchedKind = 33;
         return jjMoveStringLiteralDfa1_0(0x100000000L, 0x101000L);
      case 61:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x40000000L, 0x0L);
      case 62:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x400000000L, 0xc6000L);
      case 63:
         return jjStopAtPos(0, 72);
      case 91:
         return jjStopAtPos(0, 69);
      case 93:
         return jjStopAtPos(0, 70);
      case 94:
         jjmatchedKind = 80;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x400800L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x84000000000000L, 0x0L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x10000000000000L, 0x2L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x400000000000000L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x200000000000000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0xc008000000040200L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x100002000000100L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x1000000000000000L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x10000L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x1c00000000000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x40000000000000L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x2000000000000L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x20000L, 0x0L);
      case 117:
         return jjMoveStringLiteralDfa1_0(0x2000000000000000L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x80L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x800000000000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 21);
      case 124:
         jjmatchedKind = 45;
         return jjMoveStringLiteralDfa1_0(0x100000000000L, 0x400L);
      case 125:
         return jjStopAtPos(0, 22);
      case 126:
         return jjStopAtPos(0, 85);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x8000L) != 0L)
            return jjStopAtPos(1, 79);
         break;
      case 43:
         if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(1, 23);
         break;
      case 45:
         if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(1, 24);
         break;
      case 60:
         if ((active1 & 0x100000L) != 0L)
         {
            jjmatchedKind = 84;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x1000L);
      case 61:
         if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(1, 25);
         else if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(1, 26);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(1, 27);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(1, 31);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         else if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         else if ((active1 & 0x200L) != 0L)
            return jjStopAtPos(1, 73);
         else if ((active1 & 0x400L) != 0L)
            return jjStopAtPos(1, 74);
         else if ((active1 & 0x800L) != 0L)
            return jjStopAtPos(1, 75);
         break;
      case 62:
         if ((active1 & 0x80000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x46000L);
      case 94:
         if ((active1 & 0x400000L) != 0L)
            return jjStopAtPos(1, 86);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L, active1, 0L);
      case 98:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000000000L, active1, 0L);
      case 102:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 56, 7);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000000000L, active1, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x8001000000000L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000000000200L, active1, 0L);
      case 110:
         if ((active0 & 0x2000000000L) != 0L)
         {
            jjmatchedKind = 37;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000000000100L, active1, 0L);
      case 111:
         if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 58, 7);
         return jjMoveStringLiteralDfa2_0(active0, 0xd010000000000080L, active1, 0x2L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x1800000020000L, active1, 0x1L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000000000L, active1, 0L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000010000L, active1, 0L);
      case 124:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 44);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1);
      return 2;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x1000L) != 0L)
            return jjStopAtPos(2, 76);
         else if ((active1 & 0x2000L) != 0L)
            return jjStopAtPos(2, 77);
         break;
      case 62:
         if ((active1 & 0x40000L) != 0L)
         {
            jjmatchedKind = 82;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x4000L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000L, active1, 0L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x1L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x800800000000080L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x50000L, active1, 0L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000000L, active1, 0L);
      case 110:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(2, 36);
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000L, active1, 0x2L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x1001000000000200L, active1, 0L);
      case 114:
         if ((active0 & 0x4000000000000000L) != 0L)
         {
            jjmatchedKind = 62;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000000L, active1, 0L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x284000000000000L, active1, 0L);
      case 116:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(2, 8, 7);
         return jjMoveStringLiteralDfa3_0(active0, 0x2040000000000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(1, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, active1);
      return 3;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x4000L) != 0L)
            return jjStopAtPos(3, 78);
         break;
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000200L, active1, 0x1L);
      case 100:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(3, 7, 7);
         break;
      case 101:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(3, 17, 7);
         else if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 57, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x8080000000000000L, active1, 0L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000000000L, active1, 0L);
      case 108:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 16, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x800400000000000L, active1, 0L);
      case 112:
         if ((active0 & 0x1000000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 60, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000000000L, active1, 0L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000L, active1, 0L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x7000000000000L, active1, 0x2L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000000000L, active1, 0L);
      case 118:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, active1);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(2, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, active1);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x8010800000000000L, active1, 0L);
      case 101:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(4, 18, 7);
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 59, 7);
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000000L, active1, 0L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x2400000000000L, active1, 0x2L);
      case 107:
         if ((active1 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(4, 64, 7);
         break;
      case 108:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 51, 7);
         else if ((active0 & 0x2000000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 61, 7);
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0xc4000000000000L, active1, 0L);
      case 116:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(4, 9, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, active1);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(3, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, active1);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000000000L, active1, 0L);
      case 99:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 46, 7);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 49, 7);
         return jjMoveStringLiteralDfa6_0(active0, 0x8001000000000000L, active1, 0L);
      case 110:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 54, 7);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x2L);
      case 116:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 52, 7);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 55, 7);
         return jjMoveStringLiteralDfa6_0(active0, 0x800000000000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, active1);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(4, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, active1);
      return 6;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000000000L, active1, 0L);
      case 101:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 47, 7);
         break;
      case 104:
         if ((active0 & 0x8000000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 63, 7);
         break;
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x1000000000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0, active1);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(5, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, active1);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active1 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(7, 65, 7);
         return jjMoveStringLiteralDfa8_0(active0, 0x1000000000000L, active1, 0L);
      case 116:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 50, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, active1);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(6, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 48, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 26;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 15:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(21, 22);
                  else if (curChar == 47)
                     jjCheckNAddStates(0, 2);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(0, 1);
                  else if (curChar == 47)
                     jjAddStates(3, 4);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAddTwoStates(4, 5);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAddStates(5, 8);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(0, 1);
                  break;
               case 1:
                  if (curChar == 46)
                     jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAdd(2);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddTwoStates(4, 5);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 67)
                     kind = 67;
                  jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  if (curChar != 48)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddStates(5, 8);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddTwoStates(10, 5);
                  break;
               case 11:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddTwoStates(11, 5);
                  break;
               case 13:
                  if ((0x3000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddTwoStates(13, 5);
                  break;
               case 14:
                  if (curChar == 47)
                     jjAddStates(3, 4);
                  break;
               case 16:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 17:
                  if ((0x2400L & l) != 0L && kind > 5)
                     kind = 5;
                  break;
               case 18:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
                  break;
               case 19:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(21, 22);
                  break;
               case 21:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(21, 22);
                  break;
               case 22:
                  if (curChar == 42)
                     jjAddStates(9, 10);
                  break;
               case 23:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(24, 22);
                  break;
               case 24:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(24, 22);
                  break;
               case 25:
                  if (curChar == 47 && kind > 6)
                     kind = 6;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
               case 7:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 67)
                     kind = 67;
                  jjCheckNAdd(7);
                  break;
               case 5:
                  if ((0x100000001000L & l) != 0L && kind > 11)
                     kind = 11;
                  break;
               case 9:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(10);
                  break;
               case 10:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddTwoStates(10, 5);
                  break;
               case 12:
                  if ((0x400000004L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 16:
                  jjAddStates(0, 2);
                  break;
               case 21:
                  jjCheckNAddTwoStates(21, 22);
                  break;
               case 23:
               case 24:
                  jjCheckNAddTwoStates(24, 22);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 16:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(0, 2);
                  break;
               case 21:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(21, 22);
                  break;
               case 23:
               case 24:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(24, 22);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 26 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   16, 17, 19, 15, 20, 9, 11, 5, 12, 23, 25, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\166\157\151\144", "\151\156\164", 
"\146\154\157\141\164", null, null, null, null, null, null, "\156\165\154\154", "\164\162\165\145", 
"\146\141\154\163\145", "\50", "\51", "\173", "\175", "\53\53", "\55\55", "\53\75", "\55\75", 
"\52\75", "\57\75", "\45\75", "\75\75", "\41\75", "\74\75", "\74", "\76\75", "\76", 
"\41\151\156", "\151\156", "\53", "\55", "\52", "\57", "\45", "\75", "\174\174", "\174", 
"\160\165\142\154\151\143", "\160\162\151\166\141\164\145", "\160\162\157\164\145\143\164\145\144", 
"\163\164\141\164\151\143", "\141\142\163\164\162\141\143\164", "\146\151\156\141\154", 
"\143\157\155\160\141\164", "\72", "\162\145\164\165\162\156", "\141\163\163\145\162\164", "\151\146", 
"\145\154\163\145", "\144\157", "\167\150\151\154\145", "\154\157\157\160", 
"\165\156\164\151\154", "\146\157\162", "\146\157\162\145\141\143\150", "\142\162\145\141\153", 
"\143\157\156\164\151\156\165\145", "\73", null, "\54", "\133", "\135", "\56", "\77", "\46\75", "\174\75", 
"\136\75", "\74\74\75", "\76\76\75", "\76\76\76\75", "\46\46", "\136", "\46", 
"\76\76\76", "\76\76", "\74\74", "\176", "\136\136", "\41", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xffffffffffff0f81L, 0xffffffL, 
};
static final long[] jjtoSkip = {
   0x7eL, 0x0L, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[26];
static private final int[] jjstateSet = new int[52];
static protected char curChar;
/** Constructor. */
public WandParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public WandParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 26; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
