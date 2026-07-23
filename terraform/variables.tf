variable "aws_region" {
  description = "AWS region"
  default     = "us-east-1"
}


variable "ami_id" {
  description = "Amazon Linux 2023 AMI"
  default     = "ami-0c02fb55956c7d316"
}


variable "instance_type" {
  description = "EC2 instance size"
  default     = "t2.micro"
}


variable "key_name" {
  description = "EC2 key pair name"
}
