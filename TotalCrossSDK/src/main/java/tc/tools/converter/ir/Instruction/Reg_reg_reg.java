/*********************************************************************************
 *  TotalCross Software Development Kit                                          *
 *  Copyright (C) 2000-2012 SuperWaba Ltda.                                      *
 *  Copyright (C) 2012-2020 TotalCross Global Mobile Platform Ltda.              *
 *  All Rights Reserved                                                          *
 *                                                                               *
 *  This library and virtual machine is distributed in the hope that it will     *
 *  be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                         *
 *                                                                               *
 *  This file is covered by the GNU LESSER GENERAL PUBLIC LICENSE VERSION 2.1    *
 *  A copy of this license is located in file license.txt at the root of this    *
 *  SDK or can be downloaded here:                                               *
 *  http://www.gnu.org/licenses/lgpl-2.1.txt                                     *
 *                                                                               *
 *********************************************************************************/

package tc.tools.converter.ir.Instruction;

import tc.tools.converter.TCConstants;
import tc.tools.converter.tclass.TCCode;
import totalcross.util.Vector;

public class Reg_reg_reg extends SingleInstruction {
  public int r0;
  public int r1;
  public int r2;

  public Reg_reg_reg(int op, int line, int r0, int r1, int r2) {
    super(op, line);
    this.r0 = r0;
    this.r1 = r1;
    this.r2 = r2;
  }

  public Reg_reg_reg(int op, int line) {
    super(op, line);
  }

  public void set(int r0, int r1, int r2) {
    this.r0 = r0;
    this.r1 = r1;
    this.r2 = r2;
  }

  @Override
  public String toString() {
    String print;
    print = TCConstants.bcTClassNames[opcode] + " " + r0 + ", " + r1 + ", " + r2;
    return print;
  }

  @Override
  public void toTCCode(Vector vcode) {
    TCCode tc = new TCCode(opcode, line);
    tc.reg_reg_reg__reg0(r0);
    tc.reg_reg_reg__reg1(r1);
    tc.reg_reg_reg__reg2(r2);
    vcode.addElement(tc);
  }
}
