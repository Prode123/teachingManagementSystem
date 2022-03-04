// navList    type: 1 -----> 一级导航  2 -----> 二级导航,没有title,children[0]为二级导航名 3 -----> 二级导航名  4----> 二级导航菜单项
const userNavList = [
  { title: '教学大纲', type: 1, icon: 'outline' },
  { title: '教学进度计划表', type: 1, icon: 'statistics' },
  { title: '人才培养方案', type: 1, icon: 'role-management' },
  {
    type: 2,
    children: [
      { title: '获奖情况', type: 3, icon: 'huojiang' },
      { title: '我的奖状', type: 4 },
      { title: '奖项填报', type: 4 },
    ],
  },
];

// generation leftNav
generationLeftNav(userNavList);
