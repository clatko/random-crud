#!/usr/bin/env bash

PROJ_ROOT=$(git rev-parse --show-toplevel)

function usage() {
  echo "I deploy helm."
  echo
  echo "Usage: $0 (-h)"
  echo " -s           service; required"
  echo " -h           print out this help message"
  if [[ $# -ne 0 ]]; then
    echo
    echo "------ $@ ------"
  else
    exit 1
  fi
}

while getopts "h:s:" opt; do
  case ${opt} in
    s) SERVICE=${OPTARG}
       ;;
    h) usage ;;
    *) usage "Invalid option: -${OPTARG}" ;;
  esac
done
shift $((OPTIND-1))

if [ -z "${SERVICE}" ]; then
  usage "please provide a service name"
fi

pushd ${PROJ_ROOT}

# add repos (this will change)
helm repo add hashicorp https://helm.releases.hashicorp.com
helm repo add bitnami https://charts.bitnami.com/bitnami

# update dependencies
helm dep up ./helm/

# make sure namespace has been created
# kubectl create namespace clatko --dry-run=client -o yaml | kubectl apply -f -

# install
helm upgrade --namespace clatko --create-namespace --install ${SERVICE} ./helm/ --dry-run

popd

exit 0
