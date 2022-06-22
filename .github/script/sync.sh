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
cat ~/.ssh/known_hosts;
cat ~/.ssh/id_rsa.pub;
ssh -vT git@bitbucket.org:AnnoMMLXXVII/fantasyfranchise.git;
git remote add sync git@bitbucket.org:AnnoMMLXXVII/fantasyfranchise.git;
git remote -v;
git push sync;