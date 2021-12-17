from aws_cdk import Duration
from aws_cdk import Stack
from aws_cdk import aws_sqs as sqs
from constructs import Construct


class CdkStack(Stack):

    def __init__(self, scope: Construct, construct_id: str, **kwargs) -> None:
        super().__init__(scope, construct_id, **kwargs)

        # The code that defines your stack goes here

        # We create a simple SQS queue as an example for this project
        queue = sqs.Queue(
            self, "DummyCdkQueue",
            visibility_timeout=Duration.seconds(300),
        )
