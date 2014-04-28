package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.image.NIVision.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionProcessing extends Subsystem 
{
    private static VisionProcessing instance = null;
    
    private AxisCamera camera;          // the axis camera object (connected to the switch)
    private CriteriaCollection bigObjectsCriteria, horizontalWidthCriteria, verticalHeightCriteria;
    boolean hot;
    
    final static int MINIMUM_AREA = 0;
    final static int MAXIMUM_AREA = 350;
    final static int MINIMUM_HORIZONTAL_WIDTH = 30;
    final static int MAXIMUM_HORIZONTAL_WIDTH = 90;
    final static int MINIMUM_VERTICAL_HEIGHT = 45;
    final static int MAXIMUM_VERTICAL_HEIGHT = 115;
    
    public void initDefaultCommand() {}
    
    private VisionProcessing()
    {
        camera = AxisCamera.getInstance();
        
        hot = false;
        
        bigObjectsCriteria = new CriteriaCollection();
        bigObjectsCriteria.addCriteria(MeasurementType.IMAQ_MT_AREA, MINIMUM_AREA, MAXIMUM_AREA, true);
        
        horizontalWidthCriteria = new CriteriaCollection();
        horizontalWidthCriteria.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, MINIMUM_HORIZONTAL_WIDTH, MAXIMUM_HORIZONTAL_WIDTH, false);
        
        verticalHeightCriteria = new CriteriaCollection();
        verticalHeightCriteria.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, MINIMUM_VERTICAL_HEIGHT, MAXIMUM_VERTICAL_HEIGHT, true);
    }
    
    public void autonomous() 
    {
        ColorImage image;
        try
        {
            image = camera.getImage();
            //image = new RGBImage("/8ft.jpg");
            BinaryImage thresholdImage = image.thresholdHSL(0, 255, 0, 25, 200, 255);
            //thresholdImage.write("threshold.bmp");
            BinaryImage bigObjectsImage = thresholdImage.particleFilter(bigObjectsCriteria);
            
            SmartDashboard.putNumber("Number of Particles: ", bigObjectsImage.getNumberParticles());
            this.hot = hotOrNot(bigObjectsImage);
            SmartDashboard.putBoolean("Hot: ", hot);
            
            bigObjectsImage.free();
            thresholdImage.free();
            image.free();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean getHot()
    {
        return this.hot;
    }
    
    private boolean hotOrNot(BinaryImage bigObjectsImage)
    {
        boolean hot = false;
        try 
        {
            BinaryImage verticalImage = bigObjectsImage.particleFilter(verticalHeightCriteria);
            BinaryImage horizontalImage = bigObjectsImage.particleFilter(horizontalWidthCriteria);
            
            if((verticalImage.getNumberParticles() == 1) && (horizontalImage.getNumberParticles() == 1))
            {
                hot = true;
            }
            else
            {
                hot = false;
            }
            
            verticalImage.free();
            horizontalImage.free();
        } 
        catch (NIVisionException ex) 
        {
            ex.printStackTrace();
        }
        return hot;
    }
    
    public static VisionProcessing getInstance()
    {
        if(instance == null)
        {
            instance = new VisionProcessing();
        }
        return instance;
    }
    
}