package com.myorg;

import software.amazon.awscdk.*;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcProps;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ClusterProps;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateServiceProps;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.constructs.Construct;

public class InfrastructureStack extends Stack {
    public InfrastructureStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public InfrastructureStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // Create VPC with a AZ limit of two.
        Vpc vpc = new Vpc(this, "MyVpc", VpcProps.builder().maxAzs(2).build());

        // Create the ECS Service
        Cluster cluster = new Cluster(this, "Ec2Cluster", ClusterProps.builder().vpc(vpc).build());

        // Use the ECS Network Load Balanced Fargate Service construct to create a ECS service
        ApplicationLoadBalancedFargateService loadBalancedFargateService = ApplicationLoadBalancedFargateService.Builder.create(this, "Service")
                .cluster(cluster)
                .memoryLimitMiB(1024)
                .desiredCount(1)
                .cpu(512)
                .taskImageOptions(ApplicationLoadBalancedTaskImageOptions.builder()
                        .image(ContainerImage.fromRegistry("amazon/amazon-ecs-sample"))
                        .build())
                .build();

//        ScalableTaskCount scalableTarget = loadBalancedFargateService.service.autoScaleTaskCount(EnableScalingProps.builder()
//                .minCapacity(1)
//                .maxCapacity(20)
//                .build());
//
//        scalableTarget.scaleOnCpuUtilization("CpuScaling", CpuUtilizationScalingProps.builder()
//                .targetUtilizationPercent(50)
//                .build());
//
//        scalableTarget.scaleOnMemoryUtilization("MemoryScaling", MemoryUtilizationScalingProps.builder()
//                .targetUtilizationPercent(50)
//                .build());
    }
}
