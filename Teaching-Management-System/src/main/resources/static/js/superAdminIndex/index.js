// navList    type: 1 -----> 一级导航  2 -----> 二级导航,没有title,children[0]为二级导航名 3 -----> 二级导航名  4----> 二级导航菜单项
const userNavList = [
  { title: '首页', type: 1, icon: 'home' },
  {
    type: 2,
    children: [
      { title: '网站管理', type: 3, icon: 'website-management' },
      { title: '网站模块管理', type: 4 },
      { title: '网站布局管理', type: 4 },
    ],
  },
  { title: '添加管理员', type: 1, icon: 'add-user' },
  { title: '用户反馈', type: 1, icon: 'user-feedback' },
];

// generation leftNav
generationLeftNav(userNavList);
