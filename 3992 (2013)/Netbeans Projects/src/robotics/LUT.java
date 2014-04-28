package robotics;

import edu.wpi.first.wpilibj.*;

public class LUT 
{
    //index = feet away from goal
    double[] voltage;
    
    public LUT()
    {
        voltage = new double [55];
        
        //example values shown below
        voltage[0] = 0.5235;
        
        voltage[1] = 1.523;
        
        voltage[2] = 2.55;
                
        voltage[3] = 3.75;
        
        voltage[4] = 4.8;
        
        voltage[5] = 4.8;
        
        voltage[6] = 4.8;
        
        voltage[7] = 0.5235;
        
        voltage[8] = 1.523;
        
        voltage[9] = 2.55;
                
        voltage[10] = 3.75;
        
        voltage[11] = 4.8;
        
        voltage[12] = 4.8;
        
        voltage[13] = 4.8;
        
        voltage[14] = 0.5235;
        
        voltage[15] = 1.523;
        
        voltage[16] = 2.55;
                
        voltage[17] = 3.75;
        
        voltage[18] = 4.8;
        
        voltage[19] = 4.8;
        
        voltage[20] = 4.8;
        
        voltage[21] = 0.5235;
        
        voltage[22] = 1.523;
        
        voltage[23] = 2.55;
                
        voltage[24] = 3.75;
        
        voltage[25] = 4.8;
        
        voltage[26] = 4.8;
        
        voltage[27] = 4.8;
        
        voltage[28] = 0.5235;
        
        voltage[29] = 1.523;
        
        voltage[30] = 2.55;
                
        voltage[31] = 3.75;
        
        voltage[32] = 4.8;
        
        voltage[33] = 4.8;
        
        voltage[34] = 4.8;
        
        voltage[35] = 0.5235;
        
        voltage[36] = 1.523;
        
        voltage[37] = 2.55;
                
        voltage[38] = 3.75;
        
        voltage[39] = 4.8;
        
        voltage[40] = 4.8;
        
        voltage[41] = 4.8;
        
        voltage[42] = 0.5235;
        
        voltage[43] = 1.523;
        
        voltage[44] = 2.55;
                
        voltage[45] = 3.75;
        
        voltage[46] = 4.8;
        
        voltage[47] = 4.8;
        
        voltage[48] = 4.8;
        
        voltage[49] = 0.5235;
        
        voltage[50] = 1.523;
        
        voltage[51] = 2.55;
                
        voltage[52] = 3.75;
        
        voltage[53] = 4.8;
        
        voltage[54] = 4.8;
        //NOTE: Put values in decreasing order so that distance[0] is the smallest distance 
        //ie. distance[n] < distance[n + 1];
    }
    
    public double getVoltage(double distanceIn)
    {
        int feet = -1;
        if((distanceIn - 0.5) > (Math.floor(distanceIn)))
        {
            feet = ((int)distanceIn) + 1;
        }
        else
        {
            feet = (int)distanceIn;
        }
        
        if(feet < voltage.length)
        {
            return voltage[feet];
        }
        else
        {
            return voltage[0];
        }
    }
}