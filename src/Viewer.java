import java.util.ArrayList;

public class Viewer {
    private boolean onewWin = false;
    private boolean zeroWin = false;
    private int res;


    public Viewer(ArrayList<ArrayList<Integer>> mas, int numOfCols, int numOfRows) {

        whoWin(mas,numOfCols, numOfRows);
    }

    public void setOnewWin(boolean onewWin) {
        this.onewWin = onewWin;
    }

    public void setZeroWin(boolean zeroWin) {
        this.zeroWin = zeroWin;
    }

    public boolean isOnewWin() {
        return onewWin;
    }

    public boolean isZeroWin() {
        return zeroWin;
    }

    public void whoWin(ArrayList<ArrayList<Integer>> mas, int numOfCols, int numOfRows) {

        int i = 0;
        int j = 0;
        int ii = 0;
        int jj = 0;
        int curEl = 0;
        int buf = -1;
        int k; //счетчик в ряд (текущий элемент учитывается сразу)

        for (i = 0; i < numOfRows; i++) {
            for (j = 0; j < numOfCols; j++) {

                if (null != mas.get(i).get(j)) {//текущий элемент не пустота

                    curEl = mas.get(i).get(j);

                    if (curEl != 10) {
                        if (j > 0 && i < numOfRows - 1) {//вниз-влево ПРОСТМОТР НЕ БОЛЬШЕ 5!!!!!
                            k = 1;//считаем текущий элемент
                            ii = i + 1;
                            jj = j - 1;
                            while (ii < numOfRows && jj > -1 && null != mas.get(ii).get(jj)) {
                                buf = mas.get(ii).get(jj);

                                if (curEl == buf) {
                                    k++;
                                    if (k >= 5) {//проверяем выйграл ли
                                        if (curEl == 1) {
                                            setOnewWin(true);
                                            k = 1;
                                            break;
                                        } else {
                                            setZeroWin(true);
                                            k = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    k = 1;
                                    break;
                                }

                                ii++;
                                jj--;
                            }
                        }
                        if (i < numOfRows - 1) {//вниз
                            k = 1;
                            ii = i + 1;
                            jj = j;
                            while (ii < numOfRows && null != mas.get(ii).get(jj)) {
                                buf = mas.get(ii).get(jj);

                                if (curEl == buf) {
                                    k++;
                                    if (k >= 5) {//проверяем выйграл ли
                                        if (curEl == 1) {
                                            setOnewWin(true);
                                            k = 1;
                                            break;
                                        } else {
                                            setZeroWin(true);
                                            k = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    k = 1;
                                    break;
                                }

                                ii++;
                            }
                        }
                        if (j < numOfCols - 1 && i < numOfRows - 1) {//вниз-вправо
                            k = 1;
                            ii = i + 1;
                            jj = j + 1;
                            while (ii < numOfRows && jj < numOfCols && null != mas.get(ii).get(jj)) {
                                buf = mas.get(ii).get(jj);
                                if (curEl == buf) {
                                    k++;
                                    if (k >= 5) {
                                        if (curEl == 1) {
                                            setOnewWin(true);
                                            k = 1;
                                            break; // return
                                        } else {
                                            setZeroWin(true);
                                            k = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    k = 1;
                                    break;
                                }

                                ii++;
                                jj++;
                            }
                        }
                        if (j < numOfCols - 1) {//вправо
                            k = 1;
                            ii = i;
                            jj = j + 1;
                            while (jj < numOfCols && null != mas.get(ii).get(jj)) {
                                buf = mas.get(ii).get(jj);
                                if (curEl == buf) {
                                    k++;
                                    if (k >= 5) {
                                        if (curEl == 1) {
                                            setOnewWin(true);
                                            k = 1;
                                            break; // return
                                        } else {
                                            setZeroWin(true);
                                            k = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    k = 1;
                                    break;
                                }

                                jj++;
                            }
                        }
                    }
                }
            }//изм j
        }
        if (isOnewWin() && !isZeroWin()) {
            res = 1;
        } else if (!isOnewWin() && isZeroWin()) {
            res = -1;
        } else {
            res = 0;
        }

    }

    public int getRes() {
        return res;
    }
}
