#!/bin/bash
set -euo pipefail

echo ">> Creating buckets for the development environment."

EVIDENCES_BUCKET="codesync-task-evidences"
ATTACHMENTS_BUCKET="codesync-task-attachments"
RESOURCES_BUCKET="codesync-resources"

echo ">> Creating buckets..."

awslocal s3 mb "s3://$EVIDENCES_BUCKET"
echo ">> Bucket $EVIDENCES_BUCKET created successfully!"

awslocal s3 mb "s3://$ATTACHMENTS_BUCKET"
echo ">> Bucket $ATTACHMENTS_BUCKET created successfully!"

awslocal s3 mb "s3://$RESOURCES_BUCKET"
echo ">> Bucket $RESOURCES_BUCKET created successfully!"

echo ">> Development environment configuration created successfully."

