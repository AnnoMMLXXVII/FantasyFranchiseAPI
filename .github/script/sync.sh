#! /bin/bash

# if ! currentbranch=$(git symbolic-ref --short -q HEAD)
# then
# 	echo We are not currently on a branch.
# 	exit 1
# fi

# # Uncommited Changes - Exit script if there uncommited changes
# if ! git diff-index --quiet HEAD --; then
# 	echo "There are uncommited changes on this repository."
# 	exit 1
# fi

# # Remote exists - Exit script if remote does not exist
# git ls-remote --exit-code ${remote} >/dev/null 2>&1
# if [ $? -ne 0 ]
# then
# 	echo "Remote ${remote} does not exist"
#     exit 1
# fi

# # Root path of Repo
# rootpath=$(git rev-parse --show-toplevel)

# # Branch exists - Exit script if local branch does not exist
# git rev-parse -q --verify ${branch} >/dev/null 2>&1
# if [ $? -ne 0 ]
# then
#     echo "Branch ${branch} exists"
# fi
touch ~/.ssh/id_rsa.pub;
echo "bitbucket.org,2406:da00:ff00::22e9:9f55 ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCz/3XxtTCqIclBevSBpf0eVzlN3HqcPt4Vy0Tub2cMtqRIgLk1Vld0tspSSvfYzjLc5Y4vDKbHwEP1RWOIW6TPmOZB2vQ7JouRo9Gk0P5MEbDbBW6FjHIadm2UAXz/oVr4blzcpaoMyeljdwze5UtsOecTWXE5jJVJ4teu6SQCwazFfejcyk735H0kjMh8EfTQ6SeGfyeTO3dhBpDBX3I7cwg5aZzDTyf5ljgoOvsb163HMwn/wqw7PnfDuc/3wOKuzGrQkn4xK90SAXG09MMoZ6Ryk3WpBOBqvAIvpMrlWUIK+Jhe/naYab59UiqXTHlv7E16kovUDDUH4P9z1IkFZ4mz1wDD5xtHmVnIX8ejzbW4CNnCE1S/B303/iYu9zBwKZZ8KAtyKe2wmMDviTw9YWbDmMh1aoC9nf1x5HT0MfpptMCtEPzgs2bJ6fP40OPUrPw5PycnNP5OUDh0CxE40v9PfMNzrW8PohNoyweiOvHbD4Kvqv9hYsVnDs1vPMc=" > ~/.ssh/id_rsa.pub;
ssh -vT git@bitbucket.org:AnnoMMLXXVII/fantasyfranchise.git;
git remote add sync git@bitbucket.org:AnnoMMLXXVII/fantasyfranchise.git;
git remote -v;
git push sync;