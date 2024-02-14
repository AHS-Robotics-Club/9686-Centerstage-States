package org.firstinspires.ftc.teamcode.VISION;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subbys.MecanumDriveSubsystem;
//import org.firstinspires.ftc.teamcode.vision.pipeline.CapstoneDetector;

@Autonomous(name = "VisionRedTesting")
public class VisionTestOpMode extends CommandOpMode {
    private TeamElementSubsystem capstoneDetector;

    @Override
    public void initialize() {
        capstoneDetector = new TeamElementSubsystem(hardwareMap);
//        capstoneDetector.init();

//        FtcDashboard.getInstance().startCameraStream(capstoneDetector.getCamera(), 30);

        schedule(new WaitCommand(500).andThen(new RunCommand(() -> {
            telemetry.addData("Capstone Placement", capstoneDetector.elementDetection(telemetry));
            telemetry.update();
        })));
    }
}