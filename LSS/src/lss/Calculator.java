/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.text.DecimalFormat;
import static lss.Common.R;

/**
 *
 * @author user
 */
public class Calculator implements Common {

    private final int BASE = 0;
    private final int REM = 1;
    private final int LEVEL = 2;
    private final int ENCHANT = 3;
    private final int ELIXIR = 4;
    private final int[][] _ST = new int[5][st_list.length];
    private final int[][][] _C = new int[5][st_list.length][class_list.length];

    private final int D_SHORT = 0;
    private final int H_SHORT = 1;
    private final int C_SHORT = 2;

    private final int D_LONG = 0;
    private final int H_LONG = 1;
    private final int C_LONG = 2;
    private final int AC = 3;
    private final int ER = 4;

    private final int HP = 0;
    private final int HPR = 1;
    private final int HP_POT = 2;

    private final int D_MAGIC = 0;
    private final int H_MAGIC = 1;
    private final int C_MAGIC = 2;
    private final int MB = 3;
    private final int RED_MP = 4;

    private int red_mp;

    private final int MP = 0;
    private final int MPR = 1;
    private final int MP_POT = 2;

    private final int MR = 3;

    int level = 1;
    private int _rem = 0;
    private final int[][][] st_data = new int[class_list.length][2][6];
    private final int[] rem_data = new int[class_list.length];
    private int base_dmg_short;
    private int base_dmg_long;
    private int base_dmg_magic;
    private int base_hit_short;
    private int base_hit_long;
    private int base_hit_magic;
    int hit_short;
    int hit_long;
    private final int[] dmg_buki_ele1 = new int[elem_list.length];
    private final int[] dmg_buki_ele2 = new int[elem_list.length];

    private int mb;
    private int sp;
    private int ml;
    private int int_beta;

    int dmg_element1;
    int dmg_element2;

    private int cri_short;
    private int cri_long;
    private int cri_magic;

    private int dmg_short;
    private int dmg_long;
    private int dmg_magic;

    private double dmg_small;
    private double dmg_big;
    private double dmg_cursed;
    private double dmg_undead;

    final Buki buki = new Buki();
    final Buki buki2 = new Buki();

    final Bougu bougu[] = new Bougu[eq_list.length - 2];
    private int base_ac;
    private int equip_ac;
    private int base_er;
    Buff buff;
    boolean md_dmg = false;
    int equip_pattern = 0;
    int ac;
    int dg;
    double enemy_hit_rate;
    int cbdmg;
    int hp;
    int mp;
    int mr;
    int cls = P;

    int res_ele[] = new int[elem_list.length];
    int res_ele_c[] = new int[elem_list.length];
    int res_ail[] = new int[ailment_list.length];

    DecimalFormat format_dmg = new DecimalFormat("#0.0");
    DecimalFormat format_rate = new DecimalFormat("#0.0%");
    DecimalFormat format_rate_2 = new DecimalFormat("#0.00");
    DecimalFormat format_speed = new DecimalFormat("##0.0");

    {
        for (int i = 0; i < bougu.length; i++) {
            bougu[i] = new Bougu();
        }
    }

    {
        st_data[P][BASE][STR] = 13;
        st_data[P][BASE][DEX] = 9;
        st_data[P][BASE][CON] = 11;
        st_data[P][BASE][INT] = 9;
        st_data[P][BASE][WIS] = 11;
        st_data[P][BASE][CHA] = 13;
        st_data[P][REM][STR] = 7;
        st_data[P][REM][DEX] = 9;
        st_data[P][REM][CON] = 9;
        st_data[P][REM][INT] = 9;
        st_data[P][REM][WIS] = 9;
        st_data[P][REM][CHA] = 7;
        rem_data[P] = 9;

        st_data[K][BASE][STR] = 16;
        st_data[K][BASE][DEX] = 12;
        st_data[K][BASE][CON] = 16;
        st_data[K][BASE][INT] = 8;
        st_data[K][BASE][WIS] = 9;
        st_data[K][BASE][CHA] = 10;
        st_data[K][REM][STR] = 4;
        st_data[K][REM][DEX] = 4;
        st_data[K][REM][CON] = 4;
        st_data[K][REM][INT] = 4;
        st_data[K][REM][WIS] = 4;
        st_data[K][REM][CHA] = 4;
        rem_data[K] = 4;

        st_data[E][BASE][STR] = 10;
        st_data[E][BASE][DEX] = 12;
        st_data[E][BASE][CON] = 12;
        st_data[E][BASE][INT] = 12;
        st_data[E][BASE][WIS] = 12;
        st_data[E][BASE][CHA] = 9;
        st_data[E][REM][STR] = 8;
        st_data[E][REM][DEX] = 8;
        st_data[E][REM][CON] = 8;
        st_data[E][REM][INT] = 8;
        st_data[E][REM][WIS] = 8;
        st_data[E][REM][CHA] = 8;
        rem_data[E] = 8;

        st_data[W][BASE][STR] = 8;
        st_data[W][BASE][DEX] = 7;
        st_data[W][BASE][CON] = 12;
        st_data[W][BASE][INT] = 14;
        st_data[W][BASE][WIS] = 14;
        st_data[W][BASE][CHA] = 8;
        st_data[W][REM][STR] = 12;
        st_data[W][REM][DEX] = 12;
        st_data[W][REM][CON] = 8;
        st_data[W][REM][INT] = 6;
        st_data[W][REM][WIS] = 6;
        st_data[W][REM][CHA] = 12;
        rem_data[W] = 12;

        st_data[D][BASE][STR] = 15;
        st_data[D][BASE][DEX] = 12;
        st_data[D][BASE][CON] = 12;
        st_data[D][BASE][INT] = 11;
        st_data[D][BASE][WIS] = 10;
        st_data[D][BASE][CHA] = 8;
        st_data[D][REM][STR] = 5;
        st_data[D][REM][DEX] = 7;
        st_data[D][REM][CON] = 7;
        st_data[D][REM][INT] = 7;
        st_data[D][REM][WIS] = 7;
        st_data[D][REM][CHA] = 7;
        rem_data[D] = 7;

        st_data[R][BASE][STR] = 13;
        st_data[R][BASE][DEX] = 11;
        st_data[R][BASE][CON] = 14;
        st_data[R][BASE][INT] = 10;
        st_data[R][BASE][WIS] = 10;
        st_data[R][BASE][CHA] = 8;
        st_data[R][REM][STR] = 7;
        st_data[R][REM][DEX] = 9;
        st_data[R][REM][CON] = 6;
        st_data[R][REM][INT] = 9;
        st_data[R][REM][WIS] = 9;
        st_data[R][REM][CHA] = 9;
        rem_data[R] = 9;

        st_data[I][BASE][STR] = 9;
        st_data[I][BASE][DEX] = 10;
        st_data[I][BASE][CON] = 12;
        st_data[I][BASE][INT] = 12;
        st_data[I][BASE][WIS] = 14;
        st_data[I][BASE][CHA] = 8;
        st_data[I][REM][STR] = 10;
        st_data[I][REM][DEX] = 10;
        st_data[I][REM][CON] = 8;
        st_data[I][REM][INT] = 8;
        st_data[I][REM][WIS] = 6;
        st_data[I][REM][CHA] = 10;
        rem_data[I] = 10;

        st_data[F][BASE][STR] = 16;
        st_data[F][BASE][DEX] = 13;
        st_data[F][BASE][CON] = 16;
        st_data[F][BASE][INT] = 10;
        st_data[F][BASE][WIS] = 7;
        st_data[F][BASE][CHA] = 9;
        st_data[F][REM][STR] = 4;
        st_data[F][REM][DEX] = 4;
        st_data[F][REM][CON] = 4;
        st_data[F][REM][INT] = 4;
        st_data[F][REM][WIS] = 4;
        st_data[F][REM][CHA] = 4;
        rem_data[F] = 4;

        //ステータスボーナス
        _C[D_SHORT][STR][P] = 30;
        _C[D_SHORT][STR][K] = 10;
        _C[D_SHORT][STR][E] = 30;
        _C[D_SHORT][STR][W] = 40;
        _C[D_SHORT][STR][D] = 10;
        _C[D_SHORT][STR][R] = 10;
        _C[D_SHORT][STR][I] = 10;
        _C[D_SHORT][STR][F] = 10;

        _C[H_SHORT][STR][P] = 4;
        _C[H_SHORT][STR][K] = 3;
        _C[H_SHORT][STR][E] = 5;
        _C[H_SHORT][STR][W] = 6;
        _C[H_SHORT][STR][D] = 3;
        _C[H_SHORT][STR][R] = 4;
        _C[H_SHORT][STR][I] = 5;
        _C[H_SHORT][STR][F] = 3;

        _C[C_SHORT][STR][P] = 20;
        _C[C_SHORT][STR][K] = 20;
        _C[C_SHORT][STR][E] = 24;
        _C[C_SHORT][STR][W] = 30;
        _C[C_SHORT][STR][D] = 10;
        _C[C_SHORT][STR][R] = 20;
        _C[C_SHORT][STR][I] = 30;
        _C[C_SHORT][STR][F] = 20;

        _C[D_LONG][DEX][P] = 40;
        _C[D_LONG][DEX][K] = 40;
        _C[D_LONG][DEX][E] = 10;
        _C[D_LONG][DEX][W] = 80;
        _C[D_LONG][DEX][D] = 20;
        _C[D_LONG][DEX][R] = 40;
        _C[D_LONG][DEX][I] = 80;
        _C[D_LONG][DEX][F] = 40;

        _C[H_LONG][DEX][P] = 6;
        _C[H_LONG][DEX][K] = 6;
        _C[H_LONG][DEX][E] = 3;
        _C[H_LONG][DEX][W] = 8;
        _C[H_LONG][DEX][D] = 4;
        _C[H_LONG][DEX][R] = 7;
        _C[H_LONG][DEX][I] = 8;
        _C[H_LONG][DEX][F] = 6;

        _C[C_LONG][DEX][P] = 30;
        _C[C_LONG][DEX][K] = 40;
        _C[C_LONG][DEX][E] = 16;
        _C[C_LONG][DEX][W] = 50;
        _C[C_LONG][DEX][D] = 20;
        _C[C_LONG][DEX][R] = 40;
        _C[C_LONG][DEX][I] = 50;
        _C[C_LONG][DEX][F] = 40;

        _C[ER][DEX][P] = 6;
        _C[ER][DEX][K] = 4;
        _C[ER][DEX][E] = 6;
        _C[ER][DEX][W] = 10;
        _C[ER][DEX][D] = 4;
        _C[ER][DEX][R] = 5;
        _C[ER][DEX][I] = 9;
        _C[ER][DEX][F] = 4;

        _C[D_MAGIC][INT][P] = 40;
        _C[D_MAGIC][INT][K] = 40;
        _C[D_MAGIC][INT][E] = 30;
        _C[D_MAGIC][INT][W] = 10;
        _C[D_MAGIC][INT][D] = 40;
        _C[D_MAGIC][INT][R] = 40;
        _C[D_MAGIC][INT][I] = 25;
        _C[D_MAGIC][INT][F] = 40;

        _C[H_MAGIC][INT][P] = 20;
        _C[H_MAGIC][INT][K] = 100;
        _C[H_MAGIC][INT][E] = 16;
        _C[H_MAGIC][INT][W] = 8;
        _C[H_MAGIC][INT][D] = 24;
        _C[H_MAGIC][INT][R] = 18;
        _C[H_MAGIC][INT][I] = 12;
        _C[H_MAGIC][INT][F] = 100;

        _C[C_MAGIC][INT][P] = 80;
        _C[C_MAGIC][INT][K] = 100;
        _C[C_MAGIC][INT][E] = 30;
        _C[C_MAGIC][INT][W] = 2;
        _C[C_MAGIC][INT][D] = 30;
        _C[C_MAGIC][INT][R] = 70;
        _C[C_MAGIC][INT][I] = 20;
        _C[C_MAGIC][INT][F] = 100;

        _C[MB][INT][P] = 0;
        _C[MB][INT][K] = 0;
        _C[MB][INT][E] = 0;
        _C[MB][INT][W] = 1;
        _C[MB][INT][D] = 0;
        _C[MB][INT][R] = 0;
        _C[MB][INT][I] = 1;
        _C[MB][INT][F] = 0;

        _C[HP][CON][P] = 11;
        _C[HP][CON][K] = 16;
        _C[HP][CON][E] = 9;
        _C[HP][CON][W] = 6;
        _C[HP][CON][D] = 10;
        _C[HP][CON][R] = 12;
        _C[HP][CON][I] = 8;
        _C[HP][CON][F] = 16;

        _C[MR][WIS][P] = 10;
        _C[MR][WIS][K] = 0;
        _C[MR][WIS][E] = 25;
        _C[MR][WIS][W] = 15;
        _C[MR][WIS][D] = 10;
        _C[MR][WIS][R] = 18;
        _C[MR][WIS][I] = 20;
        _C[MR][WIS][F] = 0;
    }

    private final UI ui;
    Morph polymorph = new Morph();
    private double acc = 1.0;
    // 一段加速(ヘイスト、GP
    double acc_1 = 1.3333;
    // 二段加速(BP、ブラッドラスト、イビル
    double acc_2 = 1.3333;
    // 二段加速(ワッフル
    double acc_ew = 1.1547;
    // 三段加速(ドラゴンブラッド、酒
    double acc_3 = 1.125;
    double key_delay = 0.1815;

    double db_rate = 0.3333;
    double ef_rate = 0.4000;
    double bs_rate = 0.3333;

    public Calculator(UI ui) {
        this.ui = ui;
        rem_reset();
    }

    void update() {

        if (cls != ui.cb_cls.getSelectedIndex()) {
            cls = ui.cb_cls.getSelectedIndex();
            rem_reset();

            ui.cb_magic.removeAllItems();
            ui.cb_magic.addItem("");
            ui.cb_magic.setSelectedIndex(0);

            if (cls == E) {
                ui.cb_magic.addItem("トリプルアロー");
                ui.cb_magic.addItem("サンバースト");
                ui.cb_magic.addItem("コーンオブコールド");
                ui.cb_magic.addItem("イラプション");
                ui.cb_magic.addItem("コールライトニング");
            }
            if (cls == R) {
                ui.cb_magic.addItem("フォースレイヤー");
            }
            if (cls == W) {
                ui.cb_magic.addItem("サンバースト");
                ui.cb_magic.addItem("コーンオブコールド");
                ui.cb_magic.addItem("イラプション");
                ui.cb_magic.addItem("コールライトニング");
            }
        }

        level = ui.cb_lev.getSelectedIndex() + 1;
        ui.lev.level = level;

        for (int i = 0; i < 6; i++) {
            _ST[LEVEL][i] = 0;
            _ST[ELIXIR][i] = 0;
        }
        for (int i = 0; i < 5; i++) {
            int st = ui.cb_elixir[i].getSelectedIndex() - 1;
            if (st >= 0) {
                if (ui.cb_elixir_level[i].getSelectedIndex() + 1 <= level) {
                    _ST[ELIXIR][st]++;
                }
            }
        }
        for (int i = 0; i < ui.lev.size; i++) {
            int st = ui.lev.field[i];
            if (st >= 0) {
                if (_ST[BASE][st] + _ST[REM][st] + _ST[LEVEL][st]
                        + _ST[ELIXIR][st] < 45) {
                    if (i + 51 <= level) {
                        _ST[LEVEL][st]++;
                    }
                    ui.lev.isOverflow[i] = false;
                } else if (i + 51 <= level) {
                    ui.lev.isOverflow[i] = true;
                }

            }
            for (int j = 0; j < 5; j++) {
                int e_st = ui.cb_elixir[j].getSelectedIndex() - 1;
                if (e_st < 0) {
                    continue;
                }
                if (ui.cb_elixir_level[j].getSelectedIndex() + 1 == i + 51
                        && i + 51 <= level) {
                    if (_ST[BASE][e_st] + _ST[REM][e_st] + _ST[LEVEL][e_st]
                            + _ST[ELIXIR][e_st] < 45) {
                        _ST[ELIXIR][e_st]++;
                    } else {
                        ui.cb_elixir[j].setSelectedIndex(0);
                    }
                }
            }
        }
        ui.lev.repaint();
        if (ui.cb_elem_1.getSelectedIndex() > 0) {
            for (int i = 0; i < elem_list.length; i++) {
                dmg_buki_ele1[i] = 0;
            }

            int x = (ui.cb_elem_1.getSelectedIndex() - 1) % 5;
            int e = (ui.cb_elem_1.getSelectedIndex() - 1) / 5;
            int d[] = {1, 3, 5, 7, 9};
            dmg_buki_ele1[e] = d[x];
        }
        if (ui.cb_elem_2.getSelectedIndex() > 0) {
            for (int i = 0; i < elem_list.length; i++) {
                dmg_buki_ele2[i] = 0;
            }

            int x = (ui.cb_elem_2.getSelectedIndex() - 1) % 5;
            int e = (ui.cb_elem_2.getSelectedIndex() - 1) / 5;
            int d[] = {1, 3, 5, 7, 9};
            dmg_buki_ele2[e] = d[x];
        }

        buff = new Buff();

        // セット効果
        int set1 = 0, set2 = 0, set3 = 0;// 王家セット
        int set4 = 0, set5 = 0, set6 = 0;// 浄化セット
        int set7 = 0, set8 = 0;// 極寒、アイスクイーンセット
        int set9 = 0;// 修練者セット
        int set10 = 0, set11 = 0, set12 = 0;//釣りセット

        for (Bougu bougu1 : bougu) {
            if (bougu1.name.equals("シャイニングイアリング")) {
                set10++;
                set11++;
                set12++;
            }
            if (bougu1.name.equals("レッドムーンネックレス")) {
                set10 += 2;
            }
            if (bougu1.name.equals("ホワイトムーンネックレス")) {
                set11 += 2;
            }
            if (bougu1.name.equals("ブラックムーンネックレス")) {
                set12 += 2;
            }

            if (bougu1.name.equals("王家のイアリング")) {
                set1++;
                set2++;
                set3++;
            }
            if (bougu1.name.equals("浄化のイアリング")) {
                set4++;
                set5++;
                set6++;
            }
            if (bougu1.name.equals("王家の猛きアミュレット")) {
                set1 += 2;
            }
            if (bougu1.name.equals("王家の賢きアミュレット")) {
                set2 += 2;
            }
            if (bougu1.name.equals("王家の強きアミュレット")) {
                set3 += 2;
            }
            if (bougu1.name.equals("青呪のアミュレット")) {
                set4 += 2;
            }
            if (bougu1.name.equals("赤呪のアミュレット")) {
                set5 += 2;
            }
            if (bougu1.name.equals("緑呪のアミュレット")) {
                set6 += 2;
            }
            if (bougu1.name.contains("極寒")) {
                set7++;
            }
            if (bougu1.name.contains("アイスクイーン")) {
                set8++;
            }
            if (bougu1.name.contains("修練者")) {
                set9++;
            }
        }

        if (set10 >= 3) {
            buff.d_short += 2;
            buff.d_long += 2;
            buff.HIT_SHORT += 2;
            buff.HIT_LONG += 2;
        }
        if (set11 >= 3) {
            buff.MP += 33;
            buff.MPR += 2;
            buff.SP++;
        }
        if (set12 >= 3) {
            buff.HP += 55;
            buff.HPR += 5;
        }

        if (set1 >= 3) {
            buff.d_short += 2;
            buff.d_long += 2;
            buff.HIT_SHORT += 2;
            buff.HIT_LONG += 2;
        }
        if (set2 >= 3) {
            buff.MP += 33;
            buff.MPR += 2;
            buff.SP++;
        }
        if (set3 >= 3) {
            buff.HP += 55;
            buff.MR += 4;
            buff.HPR += 5;
        }
        if (set4 >= 3) {
            buff.ST[INT] += 2;
            buff.ST[WIS] -= 2;
        }
        if (set5 >= 3) {
            buff.ST[STR] += 2;
            buff.ST[CON] -= 2;
        }
        if (set6 >= 3) {
            buff.ST[DEX] += 2;
            buff.ST[CHA] -= 2;
        }
        if (set7 == 3) {
            buff.AC -= 5;
            buff.ST[CON] += 3;
            buff.HP += 100;
            buff.HPR += 8;
            buff.MPR += 4;
            buff.MR += 15;
            buff.element_resist[WATER] += 20;
            buff.element_coefficient[WATER] += (int) (20 / 3.125);
        }
        if (set8 == 3) {
            buff.AC -= 5;
            buff.ST[STR] += 2;
            buff.ST[CHA] += 2;
            buff.HP += 100;
            buff.MPR += 4;
            buff.element_resist[WATER] += 20;
            buff.element_coefficient[WATER] += (int) (20 / 3.125);
        }
        if (set9 == 3) {
            buff.HPR += 4;
            buff.MPR += 1;
        }

        if (ui.cb_buff[ITEM_WIZP].isSelected()) {
            if (cls == W) {
                buff.SP += 2;
                buff.MPR += 2;
            } else {
                ui.cb_buff[ITEM_WIZP].setSelected(false);
            }
        }

        // マジックドール
        if (ui.cb_buff[ITEM_MD].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD].getSelectedIndex()) {
                case 0:
                    buff.effect += "特殊攻撃(クラスタシアン/ウェアウルフ),";
                    break;
                case 1:
                    buff.weight += 0.2;
                    break;
                case 2:
                    buff.effect += "MP回復 +15,";
                    break;
                case 3:
                    buff.effect += "MP回復 +15,";
                    break;
                case 4:
                    buff.DR += 1;
                    break;
                case 5:
                    buff.effect += "特殊攻撃(クラスタシアン/ウェアウルフ),";
                case 6:
                    buff.AC -= 3;
                    buff.ailment[FREEZE] += 7;
                    break;
                case 7:
                    buff.d_long++;
                    buff.HIT_LONG++;
                    break;
                case 8:
                    buff.effect += "HP回復 +40,";
                    break;
                case 9:
                    buff.effect += "回避,";
                    break;
                case 10:
                    buff.d_short += 2;
                    buff.d_long += 2;
                    buff.MPR += 2;
                    break;
                case 11:
                    buff.MPR += 4;
                    break;
                case 17:// ブルート
                    buff.weight += 0.02;
                case 16:
                    buff.weight += 0.02;
                case 15:
                    buff.weight += 0.02;
                    buff.d_short++;
                case 14:
                    buff.weight += 0.02;
                case 13:
                    buff.weight += 0.02;
                    buff.HPR += 15;
                case 12:
                    buff.weight += 0.10;
                    ui.cb_buff[ACC1].setSelected(true);
                    break;
                case 23:// ジャイアント
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ軽減 +20,ヴァンパイアリックタッチ,";
                    break;
                case 22:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ軽減 +17,";
                    break;
                case 21:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ軽減 +14,";
                    break;
                case 20:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ軽減 +11,";
                    break;
                case 19:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ軽減 +8,";
                    break;
                case 18:
                    buff.weight += 0.10;
                    buff.effect += "ダメージ軽減 +5,";
                    break;
                case 24:
                    buff.d_short += 1;
                    break;
                case 25:
                    buff.d_short += 1;
                    buff.d_long += 1;
                    break;
                case 26:
                    buff.d_short += 1;
                    buff.d_long += 1;
                    buff.SP += 1;
                    break;
                case 27:
                    buff.d_short += 2;
                    buff.d_long += 2;
                    buff.SP += 1;
                    buff.effect += "特殊攻撃(パック/パオ),";
                    break;
            }
        }

        if (ui.cb_buff[ITEM_MD_OP].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD_OP].getSelectedIndex()) {
                case 0:
                    buff.AC -= 2;
                    break;
                case 1:
                    buff.AC -= 4;
                    break;
                case 2:
                    buff.AC -= 5;
                    buff.DR += 2;
                    break;
                case 3:
                    buff.AC -= 1;
                    buff.MR += 1;
                    break;
                case 4:
                    buff.AC -= 3;
                    buff.MR += 5;
                    break;
                case 5:
                    buff.AC -= 3;
                    buff.MR += 10;
                    break;
                case 6:
                    buff.MPR += 1;
                    break;
                case 7:
                    buff.MPR += 3;
                    break;
                case 8:
                    buff.MPR += 7;
                    break;
                case 9:
                    buff.effect += "MP回復 +1,";
                    break;
                case 10:
                    buff.effect += "MP回復 +3,";
                    break;
                case 11:
                    buff.effect += "MP回復 +7,";
                    break;
                case 12:
                    buff.HP += 10;
                    buff.MP += 10;
                    break;
                case 13:
                    buff.HP += 35;
                    buff.MP += 35;
                    break;
                case 14:
                    buff.HP += 60;
                    buff.MP += 60;
                    break;
                case 15:
                    buff.HIT_SHORT += 1;
                    buff.HIT_LONG += 1;
                    break;
                case 16:
                    buff.HIT_SHORT += 2;
                    buff.HIT_LONG += 2;
                    break;
                case 17:
                    buff.HIT_SHORT += 4;
                    buff.HIT_LONG += 4;
                    break;
            }
        }

        // 課金POT
        if (ui.cb_buff[ITEM_SEA].isSelected()) {
            switch (ui.cb_buff_group[ITEM_SEA].getSelectedIndex()) {
                case 0:
                    buff.d_short += 3;
                    buff.d_long += 3;
                    buff.HIT_SHORT += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 3;
                case 1:
                    buff.d_short += 2;
                    buff.d_long += 2;
                    buff.HIT_SHORT += 2;
                    buff.HIT_LONG += 2;
                    break;
                case 2:
                    buff.SP += 3;
                    break;
                case 3:
                    buff.ST[STR] += 2;
                    break;
                case 4:
                    buff.ST[DEX] += 2;
                    break;
                case 5:
                    buff.ST[CON] += 2;
                    break;
                case 6:
                    buff.ST[INT] += 2;
                    break;
                case 7:
                    buff.ST[WIS] += 2;
                    break;
            }
        }
        if (ui.cb_buff[ITEM_BREEZE].isSelected()) {
            switch (ui.cb_buff_group[ITEM_BREEZE].getSelectedIndex()) {
                case 0:
                    buff.HPR += 10;
                    break;
                case 1:
                    buff.MPR += 10;
                    break;
                case 2:
                    buff.HP += 120;
                    break;
                case 3:
                    buff.MP += 80;
                    break;
                case 4:
                    buff.MR += 10;
                    break;
                case 5:
                    buff.MP += 60;
                    buff.MPR += 4;
                    break;
                case 6:
                    buff.HP += 100;
                    buff.HPR += 8;
                    break;
            }
        }

        // 料理
        if (ui.cb_buff[ITEM_COOKING].isSelected()) {
            switch (ui.cb_buff_group[ITEM_COOKING].getSelectedIndex()) {
                case 2:
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.MPR += 3;
                    buff.HPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                    buff.element_resist[WATER] += 10;
                    buff.element_coefficient[WATER] += (int) (10 / 3.125);
                    buff.element_resist[WIND] += 10;
                    buff.element_coefficient[WIND] += (int) (10 / 3.125);
                    buff.element_resist[EARTH] += 10;
                    buff.element_coefficient[EARTH] += (int) (10 / 3.125);
                    break;
                case 1:
                    buff.DR += 2;
                    buff.d_long += 2;
                    buff.HIT_LONG += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                    buff.element_resist[WATER] += 10;
                    buff.element_coefficient[WATER] += (int) (10 / 3.125);
                    buff.element_resist[WIND] += 10;
                    buff.element_coefficient[WIND] += (int) (10 / 3.125);
                    buff.element_resist[EARTH] += 10;
                    buff.element_coefficient[EARTH] += (int) (10 / 3.125);
                    break;
                case 0:
                    buff.DR += 2;
                    buff.d_short += 2;
                    buff.HIT_SHORT += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                    buff.element_resist[WATER] += 10;
                    buff.element_coefficient[WATER] += (int) (10 / 3.125);
                    buff.element_resist[WIND] += 10;
                    buff.element_coefficient[WIND] += (int) (10 / 3.125);
                    buff.element_resist[EARTH] += 10;
                    buff.element_coefficient[EARTH] += (int) (10 / 3.125);
                    break;

            }
        }
        if (ui.cb_buff[ITEM_DESSERT].isSelected()) {
            switch (ui.cb_buff_group[ITEM_DESSERT].getSelectedIndex()) {
                case 0:
                    buff.DR += 2;
                    break;
                case 1:
                    buff.DR += 5;
                    break;
                case 2:
                    buff.DR += 3;
                    break;
            }
        }

//        if (ui.cb_buff[DRAGON].isSelected()) {
//            switch (ui.cb_buff_group[DRAGON].getSelectedIndex()) {
//                case 0:
//                    buff.HP += 100;
//                    buff.MP += 50;
//                    buff.HPR += 3;
//                    buff.MPR += 3;
//                    buff.d_short += 1;
//                    buff.d_long += 1;
//                    buff.HIT_CLOSE += 5;
//                    buff.element_resisit[EARTH] += 30;
//                    buff.element_coefficient[EARTH] += (int) (30 / 3.125);
//                    ui.cb_buff[W_DW].setSelected(true);
//                    break;
//                case 1:
//                    buff.HP += 100;
//                    buff.MP += 50;
//                    buff.HPR += 3;
//                    buff.MPR += 3;
//                    buff.d_short += 1;
//                    buff.d_long += 1;
//                    buff.HIT_CLOSE += 5;
//                    buff.element_resisit[WATER] += 30;
//                    buff.element_coefficient[WATER] += (int) (30 / 3.125);
//                    ui.cb_buff[W_DW].setSelected(true);
//                    break;
//                case 2:
//                    buff.HP += 100;
//                    buff.MP += 50;
//                    buff.HPR += 3;
//                    buff.MPR += 3;
//                    buff.d_short += 1;
//                    buff.d_long += 1;
//                    buff.HIT_CLOSE += 5;
//                    buff.element_resisit[WIND] += 30;
//                    buff.element_coefficient[WIND] += (int) (30 / 3.125);
//                    ui.cb_buff[W_DW].setSelected(true);
//
//            }
//        }
        if (ui.cb_buff[KOMA].isSelected()) {
            switch (ui.cb_buff_group[KOMA].getSelectedIndex()) {
                case 0:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 1;
                    buff.HIT_SHORT += 3;
                    buff.AC -= 3;
                    break;
                case 1:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 3;
                    buff.HIT_SHORT += 5;
                    buff.AC -= 8;
                    buff.SP += 1;
            }
        }

        if (ui.cb_buff[K_RA].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.DR += (level - 50) / 5 + 1;
            } else {
                ui.cb_buff[K_RA].setSelected(false);
            }
        }

        if (ui.cb_buff[K_SC].isSelected()) {
            if (level >= 50 && cls == K
                    && bougu[0].type.equals("シールド")) {
                buff.ER += 15;
            } else {
                ui.cb_buff[K_SC].setSelected(false);
            }
        }
        if (ui.cb_buff[K_CB].isSelected()) {
            if (level >= 50 && cls == K
                    && buki.type.equals("両手剣")) {
                // CB効果未実装
            } else {
                ui.cb_buff[K_CB].setSelected(false);
            }
        }
        if (ui.cb_buff[K_BA].isSelected()) {
            if (level >= 60 && cls == K) {
                buff.HIT_SHORT += 6;
            } else {
                ui.cb_buff[K_BA].setSelected(false);
            }
        }
        // レジストマジック
        if (ui.cb_buff[E_RM].isSelected()) {
            if (cls == E) {
                buff.MR += 10;
            } else {
                ui.cb_buff[E_RM].setSelected(false);
            }
        }
        // レジストエレメント
        if (ui.cb_buff[E_RE].isSelected()) {
            if (cls == E) {
                buff.element_resist[FIRE] += 10;
                buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                buff.element_resist[WATER] += 10;
                buff.element_coefficient[WATER] += (int) (10 / 3.125);
                buff.element_resist[WIND] += 10;
                buff.element_coefficient[WIND] += (int) (10 / 3.125);
                buff.element_resist[EARTH] += 10;
                buff.element_coefficient[EARTH] += (int) (10 / 3.125);
            } else {
                ui.cb_buff[E_RE].setSelected(false);
            }
        }
        // クリアーマインド
        if (ui.cb_buff[E_CM].isSelected()) {
            if (cls == E) {
                buff.ST[WIS] += 3;
            } else {
                ui.cb_buff[E_CM].setSelected(false);
            }
        }
        if (ui.cb_buff[E_BW].isSelected()) {
            if (cls == E) {
                buff.element_dmg_c[FIRE] += 6;
                buff.HIT_SHORT += 6;
            } else {
                ui.cb_buff[E_BW].setSelected(false);
            }
        }
        if (ui.cb_buff[E_FW].isSelected()) {
            if (ui.cb_buff[E_BW].isSelected()) {
                ui.cb_buff[E_FW].setSelected(false);
            } else {
                buff.element_dmg_c[FIRE] += 4;
            }
        }
        // ネイチャーズタッチ
        if (ui.cb_buff[E_NT].isSelected()) {
            if (level > 9) {
                if (level < 24) {
                    buff.HPR += level - 9;
                } else {
                    buff.HPR += 15;
                }
            }
        }
        if (ui.cb_buff[D_DE].isSelected()) {
            if (cls == D) {
                buff.ER += 12;
            } else {
                ui.cb_buff[D_DE].setSelected(false);
            }
        }
        if (ui.cb_buff[D_SA].isSelected()) {
            if (cls == D) {
                buff.MR += 5;
            } else {
                ui.cb_buff[D_SA].setSelected(false);
            }
        }
        if (ui.cb_buff[E_AP].isSelected()) {
            if (ui.cb_buff[D_DE].isSelected()) {
                ui.cb_buff[E_AP].setSelected(false);
            } else {
                buff.ER += 5;
            }
        }
        if (ui.cb_buff[E_SS].isSelected()) {
            buff.element_dmg_f[WIND] += 6;
            buff.HIT_LONG += 3;
        }
        if (ui.cb_buff[E_SE].isSelected()) {
            if (ui.cb_buff[E_SS].isSelected()) {
                ui.cb_buff[E_SE].setSelected(false);
            } else {
                buff.element_dmg_f[WIND] += 3;
                buff.HIT_LONG += 2;
            }
        }
        if (ui.cb_buff[E_WS].isSelected()) {
            if (ui.cb_buff[E_SS].isSelected()
                    || ui.cb_buff[E_SE].isSelected()) {
                ui.cb_buff[E_WS].setSelected(false);
            } else {
                buff.HIT_LONG += 6;
            }
        }
        if (ui.cb_buff[E_EG].isSelected()) {
            buff.DR += 2;
        }
        if (ui.cb_buff[W_BSK].isSelected()) {
            buff.d_short += 5;
            buff.HPR -= 255;
            buff.AC += 10;
        }
        if (ui.cb_buff[W_BA].isSelected()) {
            buff.AC -= 3;
        }
        if (ui.cb_buff[R_DS].isSelected()) {
            buff.DR += 5;
        }
        if (ui.cb_buff[R_ANTHARAS].isSelected()) {
            if (ui.cb_buff[R_FAFURION].isSelected()
                    || ui.cb_buff[R_VALAKAS].isSelected()) {
                ui.cb_buff[R_ANTHARAS].setSelected(false);
            } else {
                buff.AC -= 3;
                buff.ailment[HOLD] += 10;
            }
        }
        if (ui.cb_buff[R_FAFURION].isSelected()) {
            if (ui.cb_buff[R_ANTHARAS].isSelected()
                    || ui.cb_buff[R_VALAKAS].isSelected()) {
                ui.cb_buff[R_FAFURION].setSelected(false);
            } else {
                buff.ailment[FREEZE] += 10;
            }
        }
        if (ui.cb_buff[R_VALAKAS].isSelected()) {
            if (ui.cb_buff[R_ANTHARAS].isSelected()
                    || ui.cb_buff[R_FAFURION].isSelected()) {
                ui.cb_buff[R_VALAKAS].setSelected(false);
            } else {
                buff.HIT_SHORT += 5;
                buff.ailment[STUN] += 10;
            }
        }
        if (ui.cb_buff[I_CON].isSelected()) {
            buff.MPR += 2;
        }
        if (ui.cb_buff[I_PAT].isSelected()) {
            buff.DR += 2;
        }
        if (ui.cb_buff[I_INS].isSelected()) {
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
        }
        if (ui.cb_buff[I_IO].isSelected()) {
            buff.d_short += 4;
            buff.d_long += 4;
            buff.HIT_SHORT += 4;
        }
        if (ui.cb_buff[I_IR].isSelected()) {
            buff.SP += 2;
        }
        if (ui.cb_buff[I_ID].isSelected()) {
            buff.AC -= 8;
        }

        switch (ui.cb_pattern_l.getSelectedIndex()) {
            case 1:
                buff.ST[STR]++;
                break;
            case 2:
                buff.ST[DEX]++;
                break;
            case 3:
                buff.ST[CON]++;
                break;
            case 4:
                buff.ST[INT]++;
                break;
            case 5:
                buff.ST[WIS]++;
                break;
            case 6:
                buff.ST[CHA]++;
                break;
            case 7:
                buff.ST[STR] += 2;
                break;
            case 8:
                buff.ST[DEX] += 2;
                break;
            case 9:
                buff.ST[INT] += 2;
                break;
            case 10:
                buff.ST[STR]++;
                buff.HP += 80;
                buff.HPR += 5;
                break;
            case 11:
                buff.ST[INT]++;
                buff.MP += 50;
                buff.MPR += 3;
                break;
            case 12:
                buff.ST[STR]++;
                buff.HP += 100;
                buff.d_short++;
                buff.HPR += 8;
                break;
            case 13:
                buff.ST[INT]++;
                buff.MP += 70;
                buff.SP++;
                buff.MPR += 5;
                break;
            case 14:
                buff.ST[DEX]++;
                buff.HP += 80;
                buff.MP += 50;
                buff.d_long++;
                buff.HPR += 5;
                buff.MPR += 3;
                break;
        }
        switch (ui.cb_pattern_r.getSelectedIndex()) {
            case 1:
                buff.HP += 120;
                break;
            case 2:
                buff.MP += 80;
                break;
            case 3:
                buff.AC -= 5;
                break;
            case 4:
                buff.AC -= 9;
                break;
            case 5:
                buff.element_resist[FIRE] += 30;
                buff.element_coefficient[FIRE] += (int) (30 / 3.125);
                break;
            case 6:
                buff.element_resist[WATER] += 30;
                buff.element_coefficient[WATER] += (int) (30 / 3.125);
                break;
            case 7:
                buff.element_resist[WIND] += 30;
                buff.element_coefficient[WIND] += (int) (30 / 3.125);
                break;
            case 8:
                buff.element_resist[EARTH] += 30;
                buff.element_coefficient[EARTH] += (int) (30 / 3.125);
                break;
            case 9:
                buff.element_resist[FIRE] += 30;
                buff.element_coefficient[FIRE] += (int) (30 / 3.125);
                buff.element_resist[WATER] += 30;
                buff.element_coefficient[WATER] += (int) (30 / 3.125);
                buff.element_resist[WIND] += 30;
                buff.element_coefficient[WIND] += (int) (30 / 3.125);
                buff.element_resist[EARTH] += 30;
                buff.element_coefficient[EARTH] += (int) (30 / 3.125);
                break;
            case 10:
                buff.AC -= 9;
                buff.HP += 120;
                break;
            case 11:
                buff.AC -= 9;
                buff.MP += 80;
                break;
            case 12:
                buff.AC -= 9;
                buff.HP += 80;
                buff.MP += 50;
                break;

        }

        //エリクサールーン
        if (ui.cb_pattern_l2.getSelectedIndex() > 0 && ui.cb_pattern_l2.getSelectedIndex() < st_list.length + 1) {
            buff.ST[ui.cb_pattern_l2.getSelectedIndex() - 1]++;

            switch (cls) {
                case P:
                    buff.DR += 3;
                    break;
                case K:
                    buff.HP += 50;
                    break;
                case E:
                    buff.MP += 50;
                    break;
                case W:
                    buff.MPR += 3;
                    break;
                case D:
                    buff.AC -= 3;
                    break;
                case R:
                    buff.HIT_SHORT += 3;
                    break;
                case I:
                    buff.weight += 0.10;
                    break;
                case F:
                    buff.MR += 5;
                    break;
            }

            switch (ui.cb_pattern_r2.getSelectedIndex()) {
                case 1:
                    buff.HPR += 2;
                    break;
                case 2:
                    buff.MPR++;
                    break;
                case 3:
                    buff.d_short++;
                    buff.HIT_SHORT += 2;
                    buff.MR += 5;
                    break;
                case 4:
                    buff.d_long++;
                    buff.HIT_LONG += 2;
                    buff.MR += 5;
                    break;
                case 5:
                    buff.SP++;
                    buff.MR += 5;
                    break;
            }
        }

        if (ui.cb_buff[B_STR].isSelected()) {
            switch (ui.cb_buff_group[B_STR].getSelectedIndex()) {
                case 0:
                    buff.ST[STR] += 3;
                    break;
                case 1:
                    buff.ST[STR] += 5;
                    break;
                case 2:
                    buff.ST[STR] += 6;
                    break;
                case 3:
                    buff.ST[STR] += 7;
                    break;
            }
        }
        if (ui.cb_buff[B_DEX].isSelected()) {
            switch (ui.cb_buff_group[B_DEX].getSelectedIndex()) {
                case 0:
                    buff.ST[DEX] += 3;
                    break;
                case 1:
                    buff.ST[DEX] += 5;
                    break;
                case 2:
                    buff.ST[DEX] += 6;
                    break;
                case 3:
                    buff.ST[DEX] += 7;
                    break;
            }
        }

        acc = 1.0;

        //装備による強制ヘイスト効果
        if (buki.op.effect.contains("ヘイスト")) {
            ui.cb_buff[ACC1].setSelected(true);
        }
        for (Bougu bougu1 : bougu) {
            if (bougu1.op.effect.contains("ヘイスト")) {
                ui.cb_buff[ACC1].setSelected(true);
                break;
            }
        }

        if (ui.cb_buff[ACC1].isSelected()) {
            acc *= acc_1;
        }
        if (ui.cb_buff[ACC2].isSelected()) {
            switch (cls) {
                case P:
                    acc *= acc_2;
                    break;
                case K:
                    acc *= acc_2;
                    break;
                case W:
                    ui.cb_buff[ACC2].setSelected(false);
                    break;
                case E:
                    if (ui.cb_buff[E_DB].isSelected()) {
                        ui.cb_buff[ACC2].setSelected(false);
                    } else {
                        acc *= acc_ew;
                    }
                    break;
                case D:
                    ui.cb_buff[ACC2].setSelected(false);
                    break;
                case R:
                    acc *= acc_2;
                    break;
                case I:
                    break;
                case F:
                    acc *= acc_2;
            }
        }
        if (ui.cb_buff[ACC3].isSelected()) {
            acc *= acc_3;
        }
        buki.magic_enchant = 0;
        buki2.magic_enchant = 0;
        if (ui.cb_buff[BUKI].isSelected()) {
            switch (ui.cb_buff_group[BUKI].getSelectedIndex()) {
                case 0:
                    buki.magic_enchant = 1;
                    buki2.magic_enchant = 1;
                    buff.HIT_SHORT += 1;
                    break;
                case 1:
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    break;
                case 2:
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    buff.HIT_SHORT += 2;
                    break;
                case 3:
                    buki.magic_enchant = 5;
                    buki2.magic_enchant = 5;
                    break;
            }
        }

        if (ui.cb_buff[P_S].isSelected()) {
            buff.AC -= 8;
        }

        if (ui.cb_buff[P_BA].isSelected()) {
            switch (ui.cb_buff_group[P_BA].getSelectedIndex()) {
                case 0:
                    buff.MR += 8;
                    buff.ST[STR] += 1;
                    buff.ST[DEX] += 1;
                    buff.ST[INT] += 1;
                    break;
                case 1:
                    buff.MR += 9;
                    buff.ailment[STUN] += 2;
                    buff.ST[STR] += 1;
                    buff.ST[DEX] += 1;
                    buff.ST[INT] += 1;
                    break;
                case 2:
                    buff.MR += 10;
                    buff.ailment[STUN] += 2;
                    buff.ailment[HOLD] += 2;
                    buff.ST[STR] += 1;
                    buff.ST[DEX] += 1;
                    buff.ST[INT] += 1;
                    break;
            }
        }
        if (ui.cb_buff[P_G].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.d_short += 5;
        }

        if (ui.cb_buff[B_AC].isSelected()) {
            switch (ui.cb_buff_group[B_AC].getSelectedIndex()) {
                case 0://シールド
                    buff.AC += -2;
                    break;
                case 1://四季P
                    buff.AC += -5;
                    break;
                case 2://アーススキン
                    buff.AC += -6;
                    break;
                case 3://アースブレス
                    buff.AC += -7;
                    break;
                case 4://アイアンスキン
                    buff.AC += -10;
                    break;
            }

        }

//        if (ui.cb_buff[WAR].isSelected()) {
//            if (ui.cb_buff_group[WAR].getSelectedIndex() == 0) {
//                buff.d_long += 30;
//                buff.d_short += 30;
//            }
//
//            if (ui.cb_buff_group[WAR].getSelectedIndex() == 1) {
//                if (level >= 80) {
//                    buff.HIT_CLOSE += 5;
//                    buff.d_short += 5;
//                    buff.d_long += 5;
//                } else if (level >= 70) {
//                    buff.HIT_CLOSE += 10;
//                    buff.d_short += 8;
//                    buff.d_long += 8;
//                    buff.MR += 3;
//                    buff.AC -= 2;
//                } else if (level >= 60) {
//                    buff.HIT_CLOSE += 25;
//                    buff.d_short += 12;
//                    buff.d_long += 12;
//                    buff.SP += 5;
//                    buff.MR += 5;
//                    buff.AC -= 5;
//                } else if (level >= 52) {
//                    buff.HIT_CLOSE += 40;
//                    buff.d_short += 15;
//                    buff.d_long += 15;
//                    buff.SP += 10;
//                    buff.MR += 10;
//                    buff.AC -= 10;
//                }
//            }
//        }
        if (ui.cb_buff[VIP].isSelected()) {
            buff.HP += 120;
            buff.MP += 120;
            buff.MR += 10;
            buff.AC -= 5;
            buff.weight += 0.1;
        }

        if (ui.cb_buff[SEC].isSelected()) {
            buff.AC -= 1;
            buff.MR += 2;
            buff.DR += 1;
        }

        //重量ペナルティ
        switch (ui.cb_weight.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                buff.HIT_SHORT -= 1;
                buff.HIT_LONG -= 1;
                break;
            case 2:
                buff.HIT_SHORT -= 3;
                buff.HIT_LONG -= 3;
                break;
            case 3:
                buff.HIT_SHORT -= 5;
                buff.HIT_LONG -= 5;
        }

        for (int i = 0; i < 6; i++) {
            buff.ST[i] += buki.op.ST[i];
            for (Bougu bougu1 : bougu) {
                buff.ST[i] += bougu1.op.ST[i] + bougu1.op2.ST[i];
            }
            _ST[ENCHANT][i] = buff.ST[i];
        }

        int str = _ST[BASE][STR] + _ST[REM][STR] + _ST[LEVEL][STR]
                + _ST[ENCHANT][STR] + _ST[ELIXIR][STR];
        int pure_str = _ST[BASE][STR] + _ST[REM][STR]
                + _ST[LEVEL][STR] + _ST[ELIXIR][STR];

        int dex = _ST[BASE][DEX] + _ST[REM][DEX] + _ST[LEVEL][DEX]
                + _ST[ENCHANT][DEX] + _ST[ELIXIR][DEX];
        int pure_dex = _ST[BASE][DEX] + _ST[REM][DEX]
                + _ST[LEVEL][DEX] + _ST[ELIXIR][DEX];

        int _int = _ST[BASE][INT] + _ST[REM][INT] + _ST[LEVEL][INT]
                + _ST[ENCHANT][INT] + _ST[ELIXIR][INT];
        int pure_int = _ST[BASE][INT] + _ST[REM][INT]
                + _ST[LEVEL][INT] + _ST[ELIXIR][INT];

        //追加ダメージ
        base_dmg_short = (int) (str / 2 - 2) + (int) (level / _C[D_SHORT][STR][cls]);
        base_dmg_long = (int) (dex / 3) + (int) (level / _C[D_LONG][DEX][cls]);
        base_dmg_magic = (int) (_int / 5 - 2) + (int) (level / _C[D_MAGIC][INT][cls]);

        base_hit_short = (int) (str * 2 / 3) + level + (int) (level / _C[H_SHORT][STR][cls]);
        base_hit_long = (int) (dex - 10) + level + (int) (level / _C[H_LONG][DEX][cls]);
        base_hit_magic = (int) ((_int - 20) / 3) + (int) (level / _C[H_MAGIC][INT][cls]);

        cri_short = (int) (minasToZero(str - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_SHORT][STR][cls]);
        cri_long = (int) (minasToZero(dex - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_LONG][DEX][cls]);
        cri_magic = (int) (minasToZero(_int - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_MAGIC][INT][cls]);

        red_mp = Math.min(30, (int) (_int * 2 / 3));

        if (pure_str >= 25) {
            base_dmg_short += 1;
            base_hit_short += 1;
        }
        if (pure_str >= 35) {
            base_dmg_short += 1;
            base_hit_short += 1;
        }
        if (pure_str >= 45) {
            base_dmg_short += 3;
            base_hit_short += 3;
            cri_short += 1;
        }

        if (pure_dex >= 25) {
            base_dmg_long += 1;
            base_hit_long += 1;
        }
        if (pure_dex >= 35) {
            base_dmg_long += 1;
            base_hit_long += 1;
        }
        if (pure_dex >= 45) {
            base_dmg_long += 3;
            base_hit_long += 3;
            cri_long += 1;
        }

        if (pure_int >= 25) {
            base_dmg_magic += 1;
            base_hit_magic += 1;
        }
        if (pure_int >= 35) {
            base_dmg_magic += 1;
            base_hit_magic += 1;
        }
        if (pure_int >= 45) {
            base_dmg_magic += 3;
            base_hit_magic += 3;
        }

        dmg_short = base_dmg_short + buff.d_short;
        dmg_long = base_dmg_long + buff.d_long;
        dmg_magic = base_dmg_magic + buff.d_magic;
        sp = buff.SP + buki.op.SP;

        for (Bougu bougu1 : bougu) {
            dmg_short += bougu1.op.d_short + bougu1.op2.d_short;
            dmg_long += bougu1.op.d_long + bougu1.op2.d_long;
            dmg_magic += bougu1.op.d_magic + bougu1.op2.d_magic;
            sp += bougu1.op.SP + bougu1.op2.SP;
        }

        int st_int = _ST[BASE][INT] + _ST[REM][INT] + _ST[LEVEL][INT]
                + _ST[ENCHANT][INT] + _ST[ELIXIR][INT];

        //スペルパワー更新
        int_beta = sp + st_int;

        //マジックレベル更新
        switch (cls) {
            case P:
                ml = level / 10;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            case K:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
                }
                break;
            case E:
                ml = level / 8;
                if (ml > 6) {
                    ml = 6;
                }
                break;
            case W:
                ml = level / 4;
                if (ml > 13) {
                    ml = 13;
                }
                break;
            case D:
                ml = level / 12;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            case R:
                ml = level / 9;
                if (ml > 4) {
                    ml = 4;
                }
                break;
            case I:
                ml = level / 6;
                if (ml > 10) {
                    ml = 10;
                }
                break;
            case F:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
                }
                break;
        }

        mb = (int) (st_int / 4) + _C[MB][INT][cls];

        if (buki.type.equals("キーリンク")) {
            dmg_short = 0;
            for (int i = 0; i < 4; i++) {
                buff.element_dmg_c[i] = 0;
            }
        }

        //命中計算
        // STR,DEX,クラス,ベースステータス,レベル
        hit_short = base_hit_short;
        hit_long = base_hit_long;

        // 武器オプション,武器強化数,エンチャント
        hit_short += buki.op.HIT_SHORT + buki.enchant / 2 + buff.HIT_SHORT;
        hit_long += buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG
                + buff.HIT_SHORT;

        for (Bougu bougu1 : bougu) {
            hit_short += bougu1.op.HIT_SHORT;
            hit_long += bougu1.op.HIT_LONG + bougu1.op.HIT_SHORT;
        }

        //属性ダメージ
        dmg_short += (int) ((buff.element_dmg_c[FIRE]) * (32.0 - ui.s_target_res[FIRE].getValue() * 32 / 100) / 32.0);
        dmg_long += (int) ((buff.element_dmg_f[WIND]) * (32.0 - ui.s_target_res[WIND].getValue() * 32 / 100) / 32.0);

        dmg_element1 = 0;
        dmg_element2 = 0;

        for (int i = 0; i < elem_list.length; i++) {
            dmg_element1 += (int) (dmg_buki_ele1[i] * (32.0 - ui.s_target_res[i].getValue() * 32 / 100) / 32.0);
            dmg_element2 += (int) (dmg_buki_ele2[i] * (32.0 - ui.s_target_res[i].getValue() * 32 / 100) / 32.0);
        }

        boolean d_axe = false;
        double speed = 0;
        int buki_id = 0;
        double magic_main = 0;
        double magic_sub = 0;

        if (ui.cb_speed_auto.isSelected()) {

            if (ui.cb_eq[1].getSelectedIndex() > 0) {
                if (ui.cb_morph_level.getSelectedIndex() == 0) {
                    speed = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), W_DA);
                } else {
                    int l = Integer.parseInt((String) ui.cb_morph_level.getSelectedItem());
                    speed = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), W_DA);
                }
                buki_id = W_DA;
                d_axe = true;
            } else {
                for (int i = 0; i < buki_type_list.length; i++) {
                    if (buki.type.equals(buki_type_list[i])) {
                        if (ui.cb_morph_level.getSelectedIndex() == 0) {
                            speed = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), i);
                            magic_main = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN);
                            magic_sub = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), SUB);
                        } else {
                            int l = Integer.parseInt((String) ui.cb_morph_level.getSelectedItem());
                            speed = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), i);
                            magic_main = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), MAIN);
                            magic_sub = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), SUB);
                        }
                        buki_id = i;
                        break;
                    }
                }
            }
            ui.tf_speed.setText(format_speed.format(speed));
            ui.tf_magic_speed_main.setText(format_speed.format(magic_main));
            ui.tf_magic_speed_sub.setText(format_speed.format(magic_sub));

            ui.tf_speed.setEnabled(false);
            ui.tf_magic_speed_main.setEnabled(false);
            ui.tf_magic_speed_sub.setEnabled(false);
            ui.tf_acc.setEnabled(false);
        } else {
            speed = Double.parseDouble(ui.tf_speed.getText());
            magic_main = Double.parseDouble(ui.tf_magic_speed_main.getText());
            magic_sub = Double.parseDouble(ui.tf_magic_speed_sub.getText());
            ui.tf_speed.setEnabled(true);
            ui.tf_magic_speed_main.setEnabled(true);
            ui.tf_magic_speed_sub.setEnabled(true);
            ui.tf_acc.setEnabled(true);
        }

        double dmg_small_ave;
        double dmg_big_ave;
        double dmg_small_max = 0;
        double dmg_big_max = 0;

        double dmg_small_ave2;
        double dmg_big_ave2;
        double dmg_small_max2;
        double dmg_big_max2;

        dmg_cursed = 0.0;
        dmg_undead = 0.0;

//        ui.sp_sub.setText("");
        if (cls == F
                && ui.cb_eq[1].getSelectedIndex() != 0) {

            dmg_big_ave = (1.0 + buki.big) / 2 + buki.op.d_short + buki.enchant + buki.magic_enchant;
            dmg_small_ave = (1.0 + buki.small) / 2 + buki.op.d_short + buki.enchant + buki.magic_enchant;

            dmg_big_max = buki.big + buki.op.d_short + buki.enchant + buki.magic_enchant;
            dmg_small_max = buki.small + buki.op.d_short + buki.enchant + buki.magic_enchant;

            if (buki.material.equals("シルバー")
                    || buki.material.equals("ミスリル")
                    || buki.material.equals("オリハルコン")) {
                dmg_undead = (1.0 + 20) / 2;
                dmg_undead /= 2.0;
            }
            if (ui.tb_blessed1.isSelected()) {
                dmg_cursed = (1.0 + 3) / 2 + 3;
                dmg_cursed /= 2.0;
            }

            dmg_big_ave2 = (1.0 + buki2.big) / 2 + buki2.op.d_short + buki2.enchant + buki2.magic_enchant;
            dmg_small_ave2 = (1.0 + buki2.small) / 2 + buki2.op.d_short + buki2.enchant + buki2.magic_enchant;

            dmg_big_max2 = buki2.big + buki2.op.d_short + buki2.enchant + buki2.magic_enchant;
            dmg_small_max2 = buki2.small + buki2.op.d_short + buki2.enchant + buki2.magic_enchant;

            if (buki2.material.equals("シルバー")
                    || buki2.material.equals("ミスリル")
                    || buki2.material.equals("オリハルコン")) {
                dmg_undead = (1.0 + 20) / 2 / 2;
            } else {
                dmg_undead = 0;
            }
            if (ui.tb_blessed2.isSelected()) {
                dmg_cursed = (1.0 + 3) / 2 + 3;
                dmg_cursed /= 2.0;
            }

            dmg_big_ave = (dmg_big_ave + dmg_big_ave2) / 2.0;
            dmg_small_ave = (dmg_small_ave + dmg_small_ave2) / 2.0;

            dmg_big_max = (dmg_big_max + dmg_big_max2) / 2.0;
            dmg_small_max = (dmg_small_max + dmg_small_max2) / 2.0;

        } else {
            switch (buki.type) {
                case "ボウ":
                case "ガントレット":

                    if (ui.cb_sonsyou.isSelected() && !buki.arrow_name.equals("幸運のアロー")) {
                        dmg_big_ave = (1.0 + buki.arrow_big) / 4 + buki.op.d_long + buki.enchant;
                        dmg_small_ave = (1.0 + buki.arrow_small) / 4 + buki.op.d_long + buki.enchant;
                    } else {
                        dmg_big_ave = (1.0 + buki.arrow_big) / 2 + buki.op.d_long + buki.enchant;
                        dmg_small_ave = (1.0 + buki.arrow_small) / 2 + buki.op.d_long + buki.enchant;
                    }
                    if (buki.arrow_material.equals("シルバー")
                            || buki.arrow_material.equals("ミスリル")
                            || buki.arrow_material.equals("オリハルコン")) {
                        dmg_undead = (1.0 + 20) / 2;
                    }
                    break;
                case "キーリンク":
                    dmg_big_ave = buki.x * (1.0 + buki.y) / 2 + buki.z;
                    dmg_small_ave = buki.x * (1.0 + buki.y) / 2 + buki.z;
                    break;
                default:
                    dmg_big_ave = (1.0 + buki.big) / 2 + buki.op.d_short + buki.enchant + buki.magic_enchant;
                    dmg_small_ave = (1.0 + buki.small) / 2 + buki.op.d_short + buki.enchant + buki.magic_enchant;

                    dmg_big_max = buki.big + buki.op.d_short + buki.enchant + buki.magic_enchant;
                    dmg_small_max = buki.small + buki.op.d_short + buki.enchant + buki.magic_enchant;

                    if (buki.material.equals("シルバー")
                            || buki.material.equals("ミスリル")
                            || buki.material.equals("オリハルコン")) {
                        dmg_undead = (1.0 + 20) / 2;
                    } else {
                        dmg_undead = 0;
                    }
                    if (ui.tb_blessed1.isSelected()) {
                        dmg_cursed = (1.0 + 3) / 2 + 3;
                    } else {
                        dmg_cursed = 0;
                    }
                    break;
            }
        }

        //クリティカル処理
        switch (buki.type) {
            case "キーリンク":
                double a = 1 + 3.0 / 32.0 * (int_beta - 12);
                double b;
                if (ui.s_target_mr.getValue() - base_hit_magic <= 100) {
                    b = 1.0 - 0.01 * ((ui.s_target_mr.getValue() - base_hit_magic) / 2);
                } else {
                    b = 0.6 - 0.01 * ((ui.s_target_mr.getValue() - base_hit_magic) / 10);
                }
                dmg_big_ave *= a;
                dmg_big_ave += buki.enchant + base_dmg_magic;
                dmg_big_ave *= b;
                dmg_small_ave *= a;
                dmg_small_ave += buki.enchant + base_dmg_magic;
                dmg_small_ave *= b;
                dmg_small_ave *= cri_magic * 0.01 * 1.5 + (1 - cri_magic * 0.01) * 1.0;
                dmg_big_ave -= 0.5;
                dmg_small_ave -= 0.5;
                break;
            case "ボウ":
                dmg_big_ave = (cri_long * 0.01) * dmg_big_max
                        + (1.0 - cri_long * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_long * 0.01) * dmg_small_max
                        + (1.0 - cri_long * 0.01) * dmg_small_ave;
                break;
            default:
                cri_short += buki.critical_rate * 100;
                if (ui.cb_buff[E_SF].isSelected()) {
                    cri_short = 100;
                }
                dmg_big_ave = (cri_short * 0.01) * dmg_big_max
                        + (1.0 - cri_short * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_short * 0.01) * dmg_small_max
                        + (1.0 - cri_short * 0.01) * dmg_small_ave;
                break;
        }

        if (buki.type.equals("デュアルブレード")) {
            if (buki.name.equals("轟音のデュアルブレード(KR)")) {
//                        ui.sp_sub.setText("+" + buki.enchant + "%");
                dmg_big_ave *= 2.0 * (buki.double_hit_rate + buki.enchant * 0.01)
                        + (1.0 - (buki.double_hit_rate + buki.enchant * 0.01));
                dmg_small_ave *= 2.0 * (buki.double_hit_rate + buki.enchant * 0.01)
                        + (1.0 - (buki.double_hit_rate + buki.enchant * 0.01));

                //ダブルヒットに銀特効＋悪魔特効を乗せる
                dmg_undead *= 2.0 * (buki.double_hit_rate + buki.enchant * 0.01)
                        + (1.0 - (buki.double_hit_rate + buki.enchant * 0.01));
                dmg_cursed *= 2.0 * (buki.double_hit_rate + buki.enchant * 0.01)
                        + (1.0 - (buki.double_hit_rate + buki.enchant * 0.01));

            } else {
                dmg_big_ave *= 2.0 * buki.double_hit_rate
                        + (1.0 - buki.double_hit_rate);
                dmg_small_ave *= 2.0 * buki.double_hit_rate
                        + (1.0 - buki.double_hit_rate);

                //ダブルヒットに銀特効＋悪魔特効を乗せる
                dmg_undead *= 2.0 * buki.double_hit_rate
                        + (1.0 - buki.double_hit_rate);
                dmg_cursed *= 2.0 * buki.double_hit_rate
                        + (1.0 - buki.double_hit_rate);
            }
        }

        double fs_rate = 1.0;
        double delay;
        double power;

        double magic;
        double drain_small = 0;
        double drain_big = 0;

        double rate;
        double hit;

        if (ui.cb_mag_auto.isSelected()) {
            rate = buki.magic_rate + buki.magic_rate_plus * buki.enchant;

            delay = buki.magic_delay;
            power = buki.magic_power;

            ui.tf_mag_power.setText(format_dmg.format(power));
            ui.tf_mag_delay.setText(format_dmg.format(delay));
            ui.tf_mag_rate.setText(format_rate_2.format(rate));

            ui.tf_mag_power.setEnabled(false);
            ui.tf_mag_delay.setEnabled(false);
            ui.tf_mag_rate.setEnabled(false);

        } else {
            rate = Double.parseDouble(ui.tf_mag_rate.getText());
            delay = Double.parseDouble(ui.tf_mag_delay.getText());
            power = Double.parseDouble(ui.tf_mag_power.getText());

            ui.tf_mag_power.setEnabled(true);
            ui.tf_mag_delay.setEnabled(true);
            ui.tf_mag_rate.setEnabled(true);
        }

        magic = getMagicDamage(buki.magic_name, buki.magic_element, power);

        switch (buki.type) {
            case "ボウ":
            case "ガントレット":
                hit = HitRateCalculator.calc(!(ui.cb_mode_pc.getSelectedIndex() == 0), hit_long, 10 - ui.cb_target_ac.getSelectedIndex(), ui.cb_target_dg.getSelectedIndex() == 0, ui.cb_target_dg.getSelectedIndex() == 2);
                break;
            case "キーリンク":
                hit = 1.0;
                break;
            default:
                hit = HitRateCalculator.calc(!(ui.cb_mode_pc.getSelectedIndex() == 0), hit_short, 10 - ui.cb_target_ac.getSelectedIndex(), ui.cb_target_dg.getSelectedIndex() == 0, ui.cb_target_dg.getSelectedIndex() == 2);
                break;
        }

        if (ui.cb_hittyuu.isSelected()) {
            hit = 1.0;
        }

        double mag_dmg_min = 0.0;
        double hit_rate = hit;

//        ui.mp_syouhi.setText("0 /min");
        if (ui.cb_magic.getSelectedItem() != null) {
            double mag_dmg;
            double mag_delay;
            double motion_delay;
            double ta_rate;

            switch ((String) ui.cb_magic.getSelectedItem()) {
                case "サンバースト":
                    double base_delay = 0.5;
                    motion_delay = 60.0 / (magic_sub * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("サンバースト", "火", 88.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 17) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (20 * (1.0 - red_mp / 100.0)) + " /min");
                    }
//                    ui.bc.mag = true;
//                    ui.bc2.mag = true;
                    break;
                case "コーンオブコールド":
                    base_delay = 0.1;
                    motion_delay = 60.0 / (magic_main * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("コーンオブコールド", "水", 62.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 16) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 14 + " /min");
//                        syouhi_mp = 14;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (18 * (1.0 - red_mp / 100.0)) + " /min");
                    }
//                    ui.bc.mag = true;
//                    ui.bc2.mag = true;
                    break;
                case "イラプション":
                    base_delay = 0.1;
                    motion_delay = 60.0 / (magic_main * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("イラプション", "地", 79.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 17) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (20 * (1.0 - red_mp / 100.0)) + " /min");
                    }
                    break;
                case "コールライトニング":
                    base_delay = 0.0;
                    motion_delay = 60.0 / (magic_sub * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("コールライトニング", "風", 62.5);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 16) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 14 + " /min");
//                        syouhi_mp = 14;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (18 * (1.0 - red_mp / 100.0)) + " /min");
                    }
                    break;
                case "トリプルアロー":
                    if (buki.type.equals("ボウ")) {
                        base_delay = 0.1;
                        motion_delay = 60.0 / (magic_main * acc);
                        mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                        ta_rate = (mag_delay - motion_delay) / mag_delay + motion_delay / mag_delay * 3;
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                        hit *= ta_rate;
                    }
                    break;
            }
        }

        if (d_axe) {
            double T = 60.0 / (acc * speed) * 2;
            delay = (int) (delay / T) * T;
            rate = rate / (1 + delay * hit * rate / T) / 2;

        } else {
            double T = 60.0 / (acc * speed);
            delay = (int) (delay / T) * T;
            rate = rate / (1 + delay * hit * rate / T);
        }

        if (buki.magic_name.equals("HP吸収")) {
            drain_small += ((dmg_small_ave + dmg_element1) / 8 + 1)
                    * rate - 0.75 * rate;
            drain_big += ((dmg_big_ave + dmg_element1) / 8 + 1)
                    * rate - 0.75 * rate;
        } else {
            magic *= rate;
        }

//        if (buki.magic_motion) {
//            dmg_small_ave *= (1.0 - rate);
//            dmg_big_ave *= (1.0 - rate);
//        }
        if (buff.effect.contains("ヴァンパイアリックタッチ")) {
            double vt_rate = 0.04;
            double vt_motion = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), buki_id));
            double atk_motion = 60.0 / (speed);

            //VTモーションによる攻撃速度の低下
            speed *= (atk_motion) / (atk_motion + vt_motion * vt_rate);
        }

        //ダブルブレイク
        if (ui.cb_buff[D_DB].isSelected()) {
            double lv_bonus = ((level - 45) / 5) * 0.01;

            dmg_big_ave *= 2.0 * (db_rate + lv_bonus)
                    + (1.0 - (db_rate + lv_bonus));
            dmg_small_ave *= 2.0 * (db_rate + lv_bonus)
                    + (1.0 - (db_rate + lv_bonus));
        }

        //武器属性
        if (buki_id == W_DA) {
            dmg_big_ave += (dmg_element1 + dmg_element2) / 2;
            dmg_small_ave += (dmg_element1 + dmg_element2) / 2;

        } else {
            dmg_big_ave += dmg_element1;
            dmg_small_ave += dmg_element1;
        }
        //アバター
        if (ui.cb_buff[I_IA].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
        }
        
        //バフ効果
        switch (buki.type) {
            case "ガントレット":
            case "ボウ":
                dmg_big_ave += dmg_long;
                dmg_small_ave += dmg_long;
                break;
            case "キーリンク":
                break;
            default:
                dmg_big_ave += dmg_short;
                dmg_small_ave += dmg_short;

        }

        //ダメリダ
        dmg_big_ave -= Integer.parseInt((String) ui.cb_target_dr.getSelectedItem());
        dmg_small_ave -= Integer.parseInt((String) ui.cb_target_dr.getSelectedItem());

        //クラッシュ
        double ex = 0.0;
        if (ui.cb_buff[F_CR].isSelected()) {
            ex = level / 2.0;
        }
        //フューリー
        if (ui.cb_buff[F_FU].isSelected()) {
            dmg_big_ave = 0.15 * 0.1 * 2.0 * (dmg_big_ave + ex)
                    + (0.15 - (0.15 * 0.1)) * (dmg_big_ave + ex)
                    + (1.0 - 0.15) * dmg_big_ave;

            dmg_small_ave = 0.15 * 0.1 * 2.0 * (dmg_small_ave + ex)
                    + (0.15 - (0.15 * 0.1)) * (dmg_small_ave + ex)
                    + (1.0 - 0.15) * dmg_small_ave;
            ex = 0.0;
        }
        dmg_big_ave += ex * 0.15;
        dmg_small_ave += ex * 0.15;

        if (buff.effect.contains("特殊攻撃(クラスタシアン/ウェアウルフ)")) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット") || buki.type
                    .equals(("キーリンク")))) {
                dmg_big_ave += 0.03 * 15;
                dmg_small_ave += 0.03 * 15;
            }
        }

        if (ui.cb_buff[D_BS].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * bs_rate
                        + 1.0 * (1.0 - bs_rate);
                dmg_small_ave *= 1.5 * bs_rate
                        + 1.0 * (1.0 - bs_rate);
                dmg_big_ave -= 0.25 * bs_rate;
                dmg_small_ave -= 0.25 * bs_rate;
            }
        }

        if (ui.cb_buff[E_EF].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * ef_rate
                        + 1.0 * (1.0 - ef_rate);
                dmg_small_ave *= 1.5 * ef_rate
                        + 1.0 * (1.0 - ef_rate);

                dmg_big_ave -= 0.25 * ef_rate;
                dmg_small_ave -= 0.25 * ef_rate;
            }
        }

        if (ui.cb_buff[P_B].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * 0.3333
                        + 1.0 * (1.0 - 0.3333);
                dmg_small_ave *= 1.5 * 0.3333
                        + 1.0 * (1.0 - 0.3333);

                dmg_big_ave -= 0.25 * 0.3333;
                dmg_small_ave -= 0.25 * 0.3333;
            } else {
                ui.cb_buff[P_B].setSelected(false);
            }
        }

        if (buff.effect.contains("特殊攻撃(パック/パオ)")) {
            dmg_big_ave += (75 - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * 0.05;
            dmg_small_ave += (75 - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * 0.05;
        }

//        if (ui.i2h.isSelected()) {
//            dmg_big_ave *= 0.5;
//            dmg_small_ave *= 0.5;
//        }
//
//        switch (ui.kago.getSelectedIndex()) {
//            case 1:
//                dmg_big_ave -= 0.05 * 80;
//                dmg_small_ave -= 0.05 * 80;
//                break;
//            case 2:
//                dmg_big_ave -= 0.05 * 31;
//                dmg_small_ave -= 0.05 * 31;
//                break;
//        }
        if (ui.cb_speed_auto.isSelected()) {
            ui.tf_acc.setText(format_rate_2.format(acc));
        } else {
            acc = Double.parseDouble(ui.tf_acc.getText());
        }
        // 弱点露出
        double week = 0;
        if (cls == R
                && ui.cb_magic.getSelectedItem()
                != null) {
            if (ui.cb_magic.getSelectedItem().equals("フォースレイヤー")) {
                double week_rate = buki.week_point_exposure;
                double t = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN) * acc) + 2.0;
                t = key_delay * ((int) (t / key_delay) + 1.0);
                if (speed != 0.0) {
                    fs_rate = FSCalclator.calc(t, speed * acc) / (speed * acc);
                }
                speed *= fs_rate;
                speed *= acc;
                double n = speed * t / 60;
                double w0 = Math.pow((1 - week_rate * hit), n);
                double w1 = (week_rate * hit) * Math.pow((1 - week_rate * hit), n - 1)
                        * n;
                double w2 = Math.pow((week_rate * hit), 2)
                        * Math.pow((1 - week_rate * hit), n - 2) * n * (n - 1) / 2;
                double w3 = 1 - w0 - w1 - w2;
                week = (20 * w1 + 40 * w2 + 60 * w3) * 3 * hit;
                week *= 60 / t;

            } else {
                if (ui.cb_speed_auto.isSelected()) {
                    ui.tf_acc.setText(format_rate_2.format(acc));
                } else {
                    acc = Double.parseDouble(ui.tf_acc.getText());
                }
                speed *= acc;
            }
        } else {
            speed *= acc;
        }

        dmg_small_ave += week + magic + drain_small;
        dmg_big_ave += week + magic + drain_big;

        ui.lab_dmg_normal.setText(Integer.toString((int) (dmg_small_ave * hit * speed + mag_dmg_min))
                + " / " + Integer.toString(
                        (int) (dmg_big_ave * hit * speed + mag_dmg_min)));
        ui.lab_dmg_cursed.setText(Integer.toString((int) ((dmg_small_ave + dmg_cursed) * hit * speed + mag_dmg_min))
                + " / " + Integer.toString(
                        (int) ((dmg_big_ave + dmg_cursed) * hit * speed + mag_dmg_min)));
        ui.lab_dmg_undead.setText(Integer.toString((int) ((dmg_small_ave + dmg_cursed + dmg_undead) * hit * speed + mag_dmg_min))
                + " / " + Integer.toString(
                        (int) ((dmg_big_ave + dmg_cursed + dmg_undead) * hit * speed + mag_dmg_min)));

        switch (buki.magic_name) {
            case "":
                ui.lab_mag_info1.setText("魔法：なし");
                ui.lab_mag_info2.setText("");
                ui.tf_mag_rate.setEnabled(false);
                ui.tf_mag_delay.setEnabled(false);
                ui.tf_mag_power.setEnabled(false);

                ui.tf_mag_rate.setText("0.00");
                ui.tf_mag_delay.setText("0.0");
                ui.tf_mag_power.setText("0.0");
                break;
            case "HP吸収":
                ui.lab_mag_rate.setEnabled(true);
                ui.lab_mag_info1.setText("魔法：" + buki.magic_name);
                ui.lab_mag_info2
                        .setText("魔法ダメージ "
                                + format_dmg.format(drain_small)
                                + "/"
                                + format_dmg.format(drain_big)
                                + "  "
                                + format_rate.format(rate));
                break;
            default:
                ui.lab_mag_info1.setText("魔法："
                        + buki.magic_name);
                ui.lab_mag_info2.setText(
                        "魔法ダメージ " + format_dmg.format(magic / rate) + "  " + format_rate.format(rate));
                break;
        }
        ui.lab_hit_rate.setText("命中率：" + format_rate.format(hit_rate));

        for (int i = 0;
                i < st_list.length;
                i++) {
            ui.lab_st_sum[i].setText(Integer.toString(_ST[BASE][i] + _ST[REM][i]
                    + _ST[LEVEL][i] + _ST[ENCHANT][i] + _ST[ELIXIR][i]));

            ui.lab_st_base[i].setText(Integer.toString(_ST[BASE][i] + _ST[REM][i]));
            ui.lab_st_lev[i].setText(Integer.toString(_ST[LEVEL][i] + _ST[ELIXIR][i]));
            ui.lab_st_add[i].setText(Integer.toString(_ST[ENCHANT][i]));

        }

        ui.lab_dmg_short.setText(
                "基本ダメージ(近) : " + base_dmg_short);
        ui.lab_dmg_long.setText(
                "基本ダメージ(遠) : " + base_dmg_long);
        ui.lab_dmg_mag.setText(
                "基本ダメージ(魔) : " + base_dmg_magic);

        ui.lab_hit_short.setText("命中(近) : " + hit_short);
        ui.lab_ac_short.setText("(最大命中AC : " + Integer.toString(19 - hit_short) + ")");
        ui.lab_hit_long.setText("命中(遠) : " + hit_long);
        ui.lab_ac_long.setText("(最大命中AC : " + Integer.toString(19 - hit_long) + ")");
        ui.lab_hit_mag.setText("命中(魔) : " + base_hit_magic);

//        ui.lab_sp.setText("SP " + sp);
//        ui.lab_ml.setText("ML " + ml);
//        ui.lab_mb.setText("MB " + mb);
//        ui.lab_mag_dmg.setText("魔法ダメージ " + base_dmg_magic);
        ui.pure_status_bonus[1][0].setText(Integer.toString(base_dmg_short));
        ui.pure_status_bonus[1][5].setText(Integer.toString(base_dmg_long));
        ui.pure_status_bonus[1][15].setText(Integer.toString(base_dmg_magic));
        ui.pure_status_bonus[1][1].setText(Integer.toString(base_hit_short));
        ui.pure_status_bonus[1][6].setText(Integer.toString(base_hit_long));
        ui.pure_status_bonus[1][16].setText(Integer.toString(base_hit_magic));
        ui.pure_status_bonus[1][2].setText(Integer.toString(cri_short));
        ui.pure_status_bonus[1][7].setText(Integer.toString(cri_long));
        ui.pure_status_bonus[1][17].setText(Integer.toString(cri_magic));
        ui.pure_status_bonus[1][18].setText(Integer.toString(mb));
        ui.pure_status_bonus[1][19].setText((Integer.toString(red_mp)));

        equip_ac = 0;

        for (Bougu bougu1 : bougu) {
            equip_ac += bougu1.op.AC + bougu1.op2.AC;
        }
        if (ui.tb_ts_sp.isSelected()) {
            equip_ac += -1;
        }
        base_ac = 10 - (int) (dex / 3) - (int) (level / 6);
        base_er = (int) (dex / 2) + (int) (level / _C[ER][DEX][cls]);

        ui.pure_status_bonus[1][8].setText(Integer.toString(base_ac));
        ui.pure_status_bonus[1][9].setText(Integer.toString(base_er));

        ac = base_ac + buff.AC + equip_ac;
        int er = base_er + buff.ER;
        int dr = buff.DR;

        if (ui.cb_buff[F_AG].isSelected()) {
            dr += -ac / 10;
        }

        for (Bougu bougu1 : bougu) {
            dr += bougu1.op.DR;
            dr += bougu1.op2.DR;
        }
        dg = 0;
        if (ui.cb_buff[D_UD].isSelected() || ui.cb_buff[I_MI].isSelected()) {
            dg = 50;
        }
        ui.lab_ac.setText(Integer.toString(ac));
        ui.lab_dg.setText(Integer.toString(dg));
        ui.lab_er.setText(Integer.toString(er));
        ui.lab_dr.setText(Integer.toString(dr));

        int con = _ST[BASE][CON] + _ST[REM][CON] + _ST[LEVEL][CON]
                + _ST[ELIXIR][CON] + _ST[ENCHANT][CON];
        double equip = 0;

        for (Bougu bougu1 : bougu) {
            equip += bougu1.op.weight;
        }
        equip += buff.weight;

        int weight = (int) ((str + con) / 2) * 100 + 1000;

        ui.pure_status_bonus[1][3].setText(Integer.toString(weight));
        ui.pure_status_bonus[1][13].setText(Integer.toString(weight));

        weight *= 1 + equip;
        if (ui.cb_buff[I_RW].isSelected()) {
            ui.cb_buff[W_DW].setSelected(false);
            weight += 180;
        }
        if (ui.cb_buff[W_DW].isSelected()) {
            weight += 150;
        }
        if (weight > 5400) {
            weight = 5400;
        }

        ui.tf_weight2.setText(Integer.toString(weight));
        //重量表示
        switch (ui.cb_weight.getSelectedIndex()) {
            case 0:
                ui.tf_weight.setText(Integer.toString(weight * 2 / 6));
                break;
            case 1:
                ui.tf_weight.setText(Integer.toString(weight * 3 / 6));
                break;
            case 2:
                ui.tf_weight.setText(Integer.toString(weight * 4 / 6));
                break;
            case 3:
                ui.tf_weight.setText(Integer.toString(weight * 5 / 6));
        }
        int wis = _ST[BASE][WIS] + _ST[REM][WIS] + _ST[LEVEL][WIS]
                + _ST[ELIXIR][WIS] + _ST[ENCHANT][WIS];

        mr = minasToZero(wis - 10) * 4 + (int) (level / 2) + _C[MR][WIS][cls];
        ui.pure_status_bonus[1][23].setText(Integer.toString(mr));
        mr += buff.MR;
        mr += buki.op.MR + buki2.op.MR;
        for (Bougu bougu1 : bougu) {
            mr += bougu1.op.MR;
            mr += bougu1.op2.MR;
        }
        ui.lab_mr.setText(Integer.toString(mr));

        calcHPMP();

        for (int i = 0; i < elem_list.length; i++) {
            res_ele[i] = buff.element_resist[i];
            res_ele_c[i] = buff.element_coefficient[i];
        }
        System.arraycopy(buff.ailment, 0, res_ail, 0, ailment_list.length);

        for (Bougu bougu1 : bougu) {

            for (int i = 0; i < elem_list.length; i++) {
                res_ele[i] += bougu1.op.element_resist[i] + bougu1.op2.element_resist[i];
                res_ele_c[i] += (int) ((bougu1.op.element_resist[i] + bougu1.op2.element_resist[i]) / 3.125);
            }
            for (int i = 0; i < ailment_list.length; i++) {
                res_ail[i] += bougu1.op.ailment[i];
            }
        }

        for (int i = 0; i < elem_list.length; i++) {
            if (res_ele[i] > 100) {
                res_ele[i] = 100;
            }
            if (res_ele_c[i] > 32) {
                res_ele_c[i] = 32;
            }
            ui.lab_elem[i].setText(elem_list[i] + " " + res_ele[i] + " (" + res_ele_c[i] + ")");
        }
        for (int i = 0; i < ailment_list.length; i++) {
            ui.lab_ailment[i].setText(ailment_list[i] + " " + res_ail[i]);
        }

        int hpr = 0;
        int mpr = 0;
        int pure_con = _ST[BASE][CON] + _ST[REM][CON] + _ST[LEVEL][CON]
                + _ST[ELIXIR][CON];
        int pure_wis = _ST[BASE][WIS] + _ST[REM][WIS] + _ST[LEVEL][WIS]
                + _ST[ELIXIR][WIS];

        int hp_pot;

        if (ui.cb_buff[ITEM_BLUE].isSelected()) {
            if (wis >= 10) {
                mpr += (wis - 10) / 2;
                ui.pure_status_bonus[1][22].setText(Integer.toString((wis - 10) / 2));
            } else {
                mpr++;
            }
        }

        int tmp = (int) (wis / 5) + (int) (level / 40);
        mpr += tmp;
        if (pure_wis >= 25) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][22].setText(Integer.toString(1));
                mpr++;
            }
            mpr++;
            tmp++;
        }
        if (pure_wis >= 35) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][22].setText(Integer.toString(2));
                mpr++;
            }
            mpr++;
            tmp++;
        }
        if (pure_wis >= 45) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][22].setText(Integer.toString(5));
                mpr += 3;
            }
            mpr += 3;
            tmp += 3;
        }

        ui.pure_status_bonus[1][21].setText(Integer.toString(tmp));

        hpr += (con / 2 + level / 20);
        hp_pot = (int) (minasToZero(con - 10) / 10);

        if (pure_con >= 25) {
            hpr++;
        }
        if (pure_con >= 35) {
            hpr++;
            hp_pot++;
        }
        if (pure_con >= 45) {
            hpr += 3;
            hp_pot += 2;
        }
        ui.pure_status_bonus[1][11].setText(Integer.toString(hpr));
        ui.pure_status_bonus[1][12].setText(Integer.toString(hp_pot));

        hpr += buff.HPR;
        mpr += buff.MPR;

        hpr += buki.op.HPR + buki.op2.HPR + buki2.op.HPR + buki2.op2.HPR;
        mpr += buki.op.MPR + buki.op2.MPR + buki2.op.MPR + buki2.op2.MPR;
        for (Bougu bougu1 : bougu) {
            hpr += bougu1.op.HPR + bougu1.op2.HPR;
            mpr += bougu1.op.MPR + bougu1.op2.MPR;
        }

        if (hpr < 0) {
            hpr = 0;
        }

        int hpr2 = 0;
        int mpr2 = 0;

        for (Bougu b : bougu) {
            buff.effect += b.op.effect;
            buff.effect += b.op2.effect;
        }

        for (String split : buff.effect.split(",")) {
            if (split.contains("HP回復")) {
                hpr2 += Integer.parseInt(split.split(" ")[1]);
            }
            if (split.contains("MP回復")) {
                mpr2 += Integer.parseInt(split.split(" ")[1]);
            }
        }

        if (hpr2 > 0) {
            ui.lab_hpr.setText(hpr + "  (64秒毎 " + hpr2 + ")");
        } else {
            ui.lab_hpr.setText(Integer.toString(hpr));
        }
        if (mpr2 > 0) {
            ui.lab_mpr.setText(mpr + "  (64秒毎 " + mpr2 + ")");
        } else {
            ui.lab_mpr.setText(Integer.toString(mpr));
        }

        int pot_rate = hp_pot;
        int pot = 0;
        for (String split : buff.effect.split(",")) {
            if (split.contains("ポーション回復量")) {
                String[] a = split.split(" ");
                for (int i = 1; i < a.length; i++) {
                    if (a[i].contains("%")) {
                        pot_rate += Integer.parseInt(a[i].split("%")[0]);
                    } else {
                        pot += Integer.parseInt(a[i]);
                    }
                }

            }
        }
        if (pot_rate > 0) {
            ui.lab_pot.setText("POT回復量 +" + pot_rate + "% " + "+" + pot);
        } else {
            ui.lab_pot.setText("");
        }

        createToolTip();
    }

    private void calcHPMP() {
        hp = 0;
        mp = 0;
        int con = _ST[BASE][CON] + _ST[REM][CON];
        int wis = _ST[BASE][WIS] + _ST[REM][WIS];

        switch (cls) {
            case P:
                hp = 14;
                mp = 3;
                break;
            case K:
                hp = 16;
                mp = 2;
                break;
            case F:
                hp = 16;
                mp = 2;
                break;
            case E:
                hp = 15;
                mp = 4;
                break;
            case W:
                hp = 12;
                mp = 6;
                break;
            case D:
                hp = 12;
                mp = 4;
                break;
            case R:
                hp = 16;
                mp = 2;
                break;
            case I:
                hp = 14;
                mp = 5;
                break;
        }

        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0};
        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0};

        for (int i = 2; i <= level; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == ui.cb_elixir_level[j].getSelectedIndex() + 1) {
                    if (ui.cb_elixir[j].getSelectedIndex() - 1 == CON) {
                        con++;
                    }
                    if (ui.cb_elixir[j].getSelectedIndex() - 1 == WIS) {
                        wis++;
                    }
                }
            }
            if (i >= 51) {
                if (ui.lev.getField(i) == CON
                        && !ui.lev.isOverflow(i)) {
                    con++;
                }
                if (ui.lev.getField(i) == WIS
                        && !ui.lev.isOverflow(i)) {
                    wis++;
                }
            }

            if (con <= 25) {
                hp += 1.5 + minasToZero(con - 12) + _C[HP][CON][cls];
            } else {
                hp += 1.5 + (int) ((con + 1) / 2) + _C[HP][CON][cls];
            }

            mp += 0.5 * ((int) ((int) wis / 5) * c1[cls] + c2[cls])
                    + 0.5 * ((int) ((int) wis / 3 * c1[cls]) + c2[cls]);

        }

        if (con <= 25) {
            int min = 1 + minasToZero(con - 12) + _C[HP][CON][cls];
            int max = 2 + minasToZero(con - 12) + _C[HP][CON][cls];

            ui.pure_status_bonus[1][10].setText(min + " - " + max);
        } else {
            int min = 1 + (int) ((con + 1) / 2) + _C[HP][CON][cls];
            int max = 2 + (int) ((con + 1) / 2) + _C[HP][CON][cls];

            ui.pure_status_bonus[1][10].setText(min + " - " + max);
        }

        {
            int min = (int) ((int) (wis / 5) * c1[cls]) + c2[cls];
            int max = (int) ((int) (wis / 3) * c1[cls]) + c2[cls];

            ui.pure_status_bonus[1][20].setText(min + " - " + max);
        }

        if (con >= 25) {
            hp += 50;
        }
        if (con >= 35) {
            hp += 100;
        }
        if (con >= 45) {
            hp += 150;
        }

        if (wis >= 25) {
            mp += 50;
        }
        if (wis >= 35) {
            mp += 100;
        }
        if (wis >= 45) {
            mp += 150;
        }

        int eq_hp = buff.HP;
        int eq_mp = buff.MP;
        eq_hp += buki.op.HP + buki2.op.HP;
        eq_mp += buki.op.MP + buki2.op.HP;
        for (Bougu bougu1 : bougu) {
            eq_hp += bougu1.op.HP + bougu1.op2.HP;
            eq_mp += bougu1.op.MP + bougu1.op2.MP;
        }
        switch (cls) {
            case P:
                eq_hp += _ST[ENCHANT][CON] * 10;
                break;
            case K:
                eq_hp += _ST[ENCHANT][CON] * 16;
                break;
            case F:
                eq_hp += _ST[ENCHANT][CON] * 16;
                break;
            case E:
                eq_hp += _ST[ENCHANT][CON] * 9;
                break;
            case W:
                eq_hp += _ST[ENCHANT][CON] * 6;
                break;
            case D:
                eq_hp += _ST[ENCHANT][CON] * 9;
                break;
            case R:
                eq_hp += _ST[ENCHANT][CON] * 12;
                break;
            case I:
                eq_hp += _ST[ENCHANT][CON] * 8;
                break;
        }

        int hpp = 0;
        int mpp = 0;

//        if (ui.cb_buff[WAR].isSelected() && ui.cb_buff_group[WAR].getSelectedIndex() == 1) {
//            if (level >= 80) {
//            } else if (level >= 70) {
//                hpp += 0.1 * hp;
//                mpp += 0.1 * mp;
//            } else if (level >= 60) {
//                hpp += 0.3 * hp;
//                mpp += 0.3 * mp;
//            } else if (level >= 52) {
//                hpp += 0.5 * hp;
//                mpp += 0.5 * mp;
//            }
//        }
        if (ui.cb_buff[F_G].isSelected()) {
            hpp += 0.005 * level * hp;
            mpp += 0.005 * level * mp;
            if (ui.cb_buff[UI.W_ADS].isSelected()) {
                ui.cb_buff[UI.W_ADS].setSelected(false);
            }
        } else if (ui.cb_buff[W_ADS].isSelected()) {
            hpp += 0.2 * hp;
            mpp += 0.2 * mp;
        }

        hp = (int) (hp + eq_hp + hpp);
        mp = (int) (mp + eq_mp + mpp);

        ui.lab_hp.setText(Integer.toString(hp));
        ui.lab_mp.setText(Integer.toString(mp));

    }

    private int minasToZero(int x) {
        if (x >= 0) {
            return x;
        } else {
            return 0;
        }
    }

    void addRem(int st) {
        if (_rem > 0) {
            if (_ST[REM][st] < st_data[cls][REM][st]) {
                _ST[REM][st]++;
                _rem--;
            }
        }
    }

    void removeRem(int st) {
        if (_ST[REM][st] > 0) {
            _ST[REM][st]--;
            _rem++;
        }
    }

    private void rem_reset() {
        _rem = rem_data[cls];
        for (int i = 0; i < st_list.length; i++) {
            _ST[REM][i] = 0;
            _ST[BASE][i] = st_data[cls][BASE][i];
        }
    }

    double getMagicDamage(String magic_name, String magic_element, double dmg_magic) {
        double cri;
        if (magic_name.equals("マインドブレイク")) {
            return (sp + ml + mb) * 3.8;
        }
        if (magic_name.equals("HP吸収")) {
            // 別途計算
            return 0;
        }
        if (magic_name.equals("ムーンライトイラプション")) {
            return 7;
        }
        if (magic_name.equals("サンバースト") || magic_name.equals("コールライトニング")
                || magic_name.equals("イラプション")
                || magic_name.equals("コーンオブコールド")
                || magic_name.equals("チルタッチ")
                || magic_name.equals("ヴァンパイアリックタッチ")
                || magic_name.equals("ファイアーアロー") || magic_name.equals("アイスダガー")
                || magic_name.equals("ウインドカッター") || magic_name.equals("スラタック")
                || magic_name.equals("エネルギーボルト")) {
            cri = (double) cri_magic / 100;
        } else {
            cri = 0;
        }

        double r_element = 0;
        if (magic_element.equals("火")) {
            r_element = ui.s_target_res[FIRE].getValue();
        }
        if (magic_element.equals("水")) {
            r_element = ui.s_target_res[WATER].getValue();
        }
        if (magic_element.equals("風")) {
            r_element = ui.s_target_res[WIND].getValue();
        }
        if (magic_element.equals("地")) {
            r_element = ui.s_target_res[EARTH].getValue();
        }

        double a = 1 + 3.0 / 32.0 * (int_beta - 12) - r_element / 100.0;
        double b;
        if (magic_name.equals("エルブンアロー")) {
            b = 1.0;
        } else if (ui.s_target_mr.getValue() - base_hit_magic <= 100) {
            b = 1.0 - 0.01 * ((ui.s_target_mr.getValue() - base_hit_magic) / 2);
        } else {
            b = 0.6 - 0.01 * ((ui.s_target_mr.getValue() - base_hit_magic) / 10);
        }
        if (ui.cb_buff[I_IA].isSelected()) {
            return (dmg_magic * a + base_dmg_magic) * b * (1 - cri)
                    + (dmg_magic * a + base_dmg_magic) * b * cri * 1.5 + 10;
        } else {
            return (dmg_magic * a + base_dmg_magic) * b * (1 - cri)
                    + (dmg_magic * a + base_dmg_magic) * b * cri * 1.5;
        }
    }

    int getST_REM(int ST) {
        return _ST[REM][ST];
    }

    void createToolTip() {

        String buki_text = "";
        buki_text += "打撃値" + buki.small + "/" + buki.big;
        if (buki.two_hands) {
            buki_text += " 両手武器";
        }
        if (buki.op.HIT_SHORT > 0) {
            buki_text += " 攻撃成功+" + buki.op.HIT_SHORT;
        }
        if (buki.op.d_short > 0) {
            buki_text += " 追加打撃+" + buki.op.d_short;
        }
        if (buki.op.HIT_SHORT < 0) {
            buki_text += " 攻撃成功" + buki.op.HIT_SHORT;
        }
        if (buki.op.d_long < 0) {
            buki_text += " 追加打撃" + buki.op.d_long;
        }
        if (buki.op.HIT_LONG > 0) {
            buki_text += " 攻撃成功+" + buki.op.HIT_LONG;
        }
        if (buki.op.d_long > 0) {
            buki_text += " 追加打撃+" + buki.op.d_long;
        }
        if (buki.op.HIT_LONG < 0) {
            buki_text += " 攻撃成功" + buki.op.HIT_LONG;
        }
        if (buki.op.d_long < 0) {
            buki_text += " 追加打撃" + buki.op.d_long;
        }

        if (buki.op.HP > 0) {
            buki_text += " HP+" + buki.op.HP;
        }
        if (buki.op.HPR > 0) {
            buki_text += " HP自然回復+" + buki.op.HPR;
        }
        if (buki.op.MP > 0) {
            buki_text += " MP+" + buki.op.MP;
        }
        if (buki.op.MPR > 0) {
            buki_text += " MP自然回復+" + buki.op.MPR;
        }
        if (buki.op.SP > 0) {
            buki_text += " 魔力+" + buki.op.SP;
        }
        if (buki.op.ST[STR] > 0) {
            buki_text += " STR+" + buki.op.ST[STR];
        }
        if (buki.op.ST[DEX] > 0) {
            buki_text += " DEX+" + buki.op.ST[DEX];
        }
        if (buki.op.ST[CON] > 0) {
            buki_text += " CON+" + buki.op.ST[CON];
        }
        if (buki.op.ST[INT] > 0) {
            buki_text += " INT+" + buki.op.ST[INT];
        }
        if (buki.op.ST[WIS] > 0) {
            buki_text += " WIS+" + buki.op.ST[WIS];
        }
        if (buki.op.ST[CHA] > 0) {
            buki_text += " CHA+" + buki.op.ST[CHA];
        }
        ui.cb_eq[0].setToolTipText(buki_text);

        for (int i = 0; i < bougu.length; i++) {
            ui.cb_eq[i + 2].setToolTipText(bougu[i].getText());
        }

    }

}
