import java.util.Arrays;

public class homeWork {
    /**
     * ƽ����
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //���ֲ��ң�y=x^2,���������������½�(0-x)
        if(x==0||x==1){
            return x;
        }
        long left=1,right=x,mid=1;
        while(left<=right){
            mid = left+(right-left)/2;
            if(mid*mid == x){
                return (int)mid;
            }else if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return (int)right;
    }
    /**
     * ţ�ٵ�����
     * ����б�ʹ�ʽ�Ƶ�res=(cur+a/cur)/2
     */
    public int mySqrt(int x){
        long cur=x;
        while(cur*cur>x){
            cur=(x+x/cur)/2;
        }
        return (int)cur;
    }
    /**
     * 1. ����ˮ����
     * https://leetcode-cn.com/problems/lemonade-change/description/
     */
    public boolean lemonadeChange(int[] bills) {
        //ջ��ֵ��5��ֱ�ӷ��룬��5��5��2����pop֮ǰ��5���ڷ��룬4����pop5��3���ڷ���
        //�������ֻ��5��10��20�����10000��(bills.length<10000)
        int five =0,ten=0;
        //1�������������
        // if(bills.length == 0){
        //     return true;
        // }
        // if(bills.length == 1 && bills[0] ==5){
        //     return true;
        // }else if(bills.length == 1 && (bills[0] == 10 || bills[0] == 20)){
        //     return false;
        // }
        // //2.̰���㷨�ж�ѭ�������ݣ�20������10��5�������ȫ��5��
        // for(int i=1;i<bills.length;i++){
        //     if(bills[i] == 5){
        //         five++;
        //     }
        //     if(bills[i] == 10){
        //         if(five>0){
        //             five--;
        //             ten++;
        //         }else{
        //             return false;
        //         }
        //     }
        //     if(bills[i] == 20){
        //         if(five>0 && ten>0){
        //             five--;
        //             ten--;
        //         }else if(five>2){
        //             five -= 3;
        //         }else{
        //             return false;
        //         }
        //     }
        // }
        // return true;

        //�ύʧ�ܺ�д���˵�
        //1.���⴦��
        if(bills.length < 1){
            return true;
        }
        if(bills[0] != 5){
            return false;
        }
        for(int i=0;i<bills.length;i++){
            if(bills[i] ==5){
                five++;
            }else if(bills[i] == 10){
                if(five<1){
                    return false;
                }
                five--;
                ten++;
            }else{
                if(five>0 && ten >0){
                    five--;
                    ten--;
                }else if(five>2){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * ������Ʊ�����ʱ����
     * ˼·��̰���㷨����ȡ�ֲ����Ž⣬Ȼ��ֻ�Ծֲ������������
     */
    public int maxProfit(int[] prices) {
        //̰���㷨���ֲ����ţ��ֲ�Ϊ������룬���򲻼�
        int res=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]<=0){
                continue;
            }
            res+=prices[i+1]-prices[i];
        }
        return res;
    }
    /**
     * �ַ�����
     * ˼·��̰���㷨����������θ��С�ĺ���
     */
    public int findContentChildren(int[] children, int[] cookies) {
        //1.���������ƥ������1������2���Ƿ��ж�Ӧ��
        //2.̰���㷨���ֲ�����������С�ĺ���
        //���������������Ҫ��������ѭ������
        // if(cookies.length ==0 || children.length == 0){
        //     return 0;
        // }
        //����
        Arrays.sort(cookies);
        Arrays.sort(children);
        //��������������ĺ�������
        int greedchild=0;
        //int child=0,cooke=0;
        //ѭ������������С�ĺ���
        // for(child=0,cooke=0;child<=children.length && cooke<=cookies.length;child++,cooke++){
        for(int cooke=0;greedchild<children.length && cooke<cookies.length;cooke++){
            if(children[greedchild]<= cookies[cooke]){
                greedchild++;
            }
        }
        // while(cooke<cookies.length && greedchild<children.length){
        //     if(cookies[cooke]>=children[greedchild]){
        //         greedchild++;
        //     }
        //     cooke++;
        // }
        return greedchild;
    }
    /**
     *ģ�����߻�����
     * ˼·��
     * ��������ⶼû����
     */
    public int robotSim(int[] commands, int[][] obstacles) {

    }

    /**
     * ʹ�ö��ֲ��ң�Ѱ��һ������������ [4, 5, 6, 7, 0, 1, 2] �м�����ĵط�
     * ˼·�����ֲ��ң��Ƚ��м�ֵ����������Ԫ�ش�С���������ģ���Ƚ��м�Ԫ�غ���βԪ�ش�С���ж������λ�����������һ��
     */
    public int findInorder(int[] nums){
        //���⴦��
        if(nums.length <= 2){
            return -1;
        }
        int left=0,right=nums.length-1,mid;
        while(left<right){
            mid = left+(right-left)/2;
            //���м�ֵ�����Ҳ���С����࣬���������λ��
            if(nums[mid]>nums[mid+1] && nums[mid]<nums[mid-1]){
                return mid;
            }else if(nums[mid] > nums[mid-1]){
                //�ж����Ҳ�
                if(nums[mid]>nums[left]){
                    left = mid+1;
                }else {
                    right=mid-1;
                }
            }else if(nums[mid] < nums[mid+1]){
                //�ж������
                if(nums[mid]<nums[right]){
                    right =mid-1;
                }else{
                    left = mid+1;
                }

            }
        }
        return -1;
    }
}
